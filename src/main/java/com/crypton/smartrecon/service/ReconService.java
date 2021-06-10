package com.crypton.smartrecon.service;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Value;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.tuples.generated.Tuple5;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.utils.Convert;
import org.web3j.utils.Convert.Unit;
import com.crypton.smartrecon.dto.BookingDetailsResponse;
import com.crypton.smartrecon.enums.BookingStatus;
import com.crypton.smartrecon.enums.PaymentStatus;
import com.crypton.smartrecon.properties.ReconProperties;
import recon.Recon;
import recon.ReconFactory;

public class ReconService {

  private final String contractAddress;

  private final Web3j web3j;

  private final ReconProperties config;

  @Value("${recon.contract.owner-address}")
  private String ownerAddress;

  @Value("${recon.contract.hotel.address}")
  private String hotelOwnerAddress;

  @Value("${recon.contract.oyo.address}")
  private String oyoAddress;

  public ReconService(String contractAddress, Web3j web3j, ReconProperties config) {
    this.contractAddress = contractAddress;
    this.web3j = web3j;
    this.config = config;
  }

  public BigInteger getBalance() throws IOException {
    return web3j.ethGetBalance(contractAddress, DefaultBlockParameterName.LATEST).send()
        .getBalance();
  }

  private ReconFactory loadFactoryContract() {
    return ReconFactory
        .load(contractAddress, web3j, txManager(false), config.gas());
  }

  private Recon loadReconContract(String contractAddress, Boolean customer) {
    return Recon
        .load(contractAddress, web3j, txManager(customer), config.gas());
  }

  private TransactionManager txManager(Boolean customer) {
    return new RawTransactionManager(
        web3j, Credentials.create(getPrivateKey(customer)), 1337);
  }

  public String createReconContract() throws Exception {
    loadFactoryContract()
        .createReconContract(BigInteger.ONE, new BigInteger("20000000"),
            BigInteger.valueOf(70), BigInteger.valueOf(30), hotelOwnerAddress,
            oyoAddress).sendAsync()
        .get(100000, TimeUnit.MILLISECONDS);
    return "Contract Deployed";
  }

  @SuppressWarnings("unchecked")
  public List<String> getDeployedContracts() throws Exception {
    return loadFactoryContract()
        .getDeployedRecons().sendAsync().get(100000, TimeUnit.MILLISECONDS);
  }

  public BookingDetailsResponse payNow(String bookingId, String bookingAmount) throws Exception {
    Recon recon = loadReconContract(getDeployedContracts().get(0), true);
    BigInteger bookingAmountInWei = Convert.toWei(bookingAmount, Unit.ETHER).toBigInteger();
    recon.payNow(new BigInteger(bookingId), bookingAmountInWei).sendAsync()
        .get(100000, TimeUnit.MILLISECONDS);
    return getBookingDetails(bookingId);
  }

  public BookingDetailsResponse payLater(String bookingId, String bookingAmount) throws Exception {
    Recon recon = loadReconContract(getDeployedContracts().get(0), true);
    BigInteger bookingAmountInWei = Convert.toWei(bookingAmount, Unit.ETHER).toBigInteger();
    recon.payLater(new BigInteger(bookingId), bookingAmountInWei).sendAsync()
        .get(100000, TimeUnit.MILLISECONDS);
    return getBookingDetails(bookingId);
  }

  public BookingDetailsResponse getBookingDetails(String bookingId) throws Exception {
    Recon recon = loadReconContract(getDeployedContracts().get(0), false);
    Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, Boolean> response =
        recon.getBookingDetails(new BigInteger(bookingId)).sendAsync()
            .get(100000, TimeUnit.MILLISECONDS);
    return getBookingDetails(response);
  }

  public String getAllBookings() throws Exception {
    Recon recon = loadReconContract(getDeployedContracts().get(0), true);
    recon.getAllBookings();
    return "";
  }

  public BookingDetailsResponse cancelBooking(String bookingId) throws Exception {
    Recon recon = loadReconContract(getDeployedContracts().get(0), true);
    recon.cancelBooking(new BigInteger(bookingId)).sendAsync().get(100000, TimeUnit.MILLISECONDS);
    return getBookingDetails(bookingId);
  }

  public BookingDetailsResponse checkout(String bookingId) throws Exception {
    Recon recon = loadReconContract(getDeployedContracts().get(0), true);
    recon.checkout(new BigInteger(bookingId)).sendAsync()
        .get(100000, TimeUnit.MILLISECONDS);
    return getBookingDetails(bookingId);
  }

  public BookingDetailsResponse checkIn(String bookingId) throws Exception {
    Recon recon = loadReconContract(getDeployedContracts().get(0), true);
    Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, Boolean> bookingDetails =
        recon.getBookingDetails(new BigInteger(bookingId)).sendAsync()
            .get(100000, TimeUnit.MILLISECONDS);
    if (bookingDetails.component5()) {
      recon.payNowCheckIn(new BigInteger(bookingId)).sendAsync()
          .get(100000, TimeUnit.MILLISECONDS);
    } else {
      recon.payLaterCheckIn(new BigInteger(bookingId), bookingDetails.component2()).sendAsync()
          .get(100000, TimeUnit.MILLISECONDS);
    }
    return getBookingDetails(bookingId);
  }

  private BookingDetailsResponse getBookingDetails(
      Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, Boolean> response) {
    BookingDetailsResponse bookingDetailsResponse = new BookingDetailsResponse();
    bookingDetailsResponse.setBookingId(response.component1().toString());
    bookingDetailsResponse
        .setBookingAmount(
            Convert.fromWei(response.component2().toString(), Unit.ETHER).toString());
    bookingDetailsResponse.setBookingStatus(BookingStatus.getByValue(
        Integer.valueOf(response.component3().toString())));
    bookingDetailsResponse.setPaymentStatus(PaymentStatus.getByValue(
        Integer.valueOf(response.component4().toString())));
    return bookingDetailsResponse;
  }

  private String getPrivateKey(Boolean customer) {
    if (Boolean.TRUE.equals(customer)) {
      return "909bde7b6fcb97b570c3037f3b7eafb99544c61a4a54960616a4f6358e204059";
    }
    return "79c6a5435ebd62d2a963d504c5fbb8cea80555a9f7f8e9da47c7bd1e2a7f9b58";
  }
}
