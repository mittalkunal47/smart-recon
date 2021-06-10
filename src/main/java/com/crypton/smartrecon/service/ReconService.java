package com.crypton.smartrecon.service;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Value;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.tuples.generated.Tuple5;
import org.web3j.tx.ClientTransactionManager;
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

  private ReconFactory loadFactoryContract(String accountAddress) {
    return ReconFactory.load(contractAddress, web3j, txManager(accountAddress), config.gas());
  }

  private Recon loadReconContract(String contractAddress, String accountAddress) {
    return Recon.load(contractAddress, web3j, txManager(accountAddress), config.gas());
  }

  private TransactionManager txManager(String accountAddress) {
    return new ClientTransactionManager(web3j, accountAddress);
  }

  public String CreateReconContract() throws Exception {
    loadFactoryContract(ownerAddress)
        .createReconContract(BigInteger.ONE, new BigInteger("20000000"),
            BigInteger.valueOf(70), BigInteger.valueOf(30), hotelOwnerAddress,
            oyoAddress).sendAsync()
        .get(100000, TimeUnit.MILLISECONDS);
    return "Contract Deployed";
  }

  @SuppressWarnings("unchecked")
  public List<String> getDeployedContracts() throws Exception {
    return loadFactoryContract(ownerAddress)
        .getDeployedRecons().sendAsync().get(100000, TimeUnit.MILLISECONDS);
  }

  public BookingDetailsResponse payNow(String bookingId, String bookingAmount) throws Exception {
    Recon recon = loadReconContract(getDeployedContracts().get(0), ownerAddress);
    BigInteger bookingAmountInWei = Convert.toWei(bookingAmount, Unit.ETHER).toBigInteger();
    recon.payNow(new BigInteger(bookingId), bookingAmountInWei).sendAsync()
        .get(100000, TimeUnit.MILLISECONDS);
    return getBookingDetails(bookingId);
  }

  public BookingDetailsResponse payLater(String bookingId, String bookingAmount) throws Exception {
    Recon recon = loadReconContract(getDeployedContracts().get(0), ownerAddress);
    BigInteger bookingAmountInWei = Convert.toWei(bookingAmount, Unit.ETHER).toBigInteger();
    recon.payLater(new BigInteger(bookingId), bookingAmountInWei).sendAsync()
        .get(100000, TimeUnit.MILLISECONDS);
    return getBookingDetails(bookingId);
  }

  public BookingDetailsResponse getBookingDetails(String bookingId) throws Exception {
    Recon recon = loadReconContract(getDeployedContracts().get(0), ownerAddress);
    Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, Boolean> response =
        recon.getBookingDetails(new BigInteger(bookingId)).sendAsync()
            .get(100000, TimeUnit.MILLISECONDS);
    return getBookingDetails(response);
  }

  public String getAllBookings() throws Exception {
    Recon recon = loadReconContract(getDeployedContracts().get(0), ownerAddress);
    recon.getAllBookings();
    return "";
  }

  public BookingDetailsResponse cancelBooking(String bookingId) throws Exception {
    Recon recon = loadReconContract(getDeployedContracts().get(0), ownerAddress);
    recon.cancelBooking(new BigInteger(bookingId)).sendAsync().get(100000, TimeUnit.MILLISECONDS);
    return getBookingDetails(bookingId);
  }

  public BookingDetailsResponse checkout(String bookingId) throws Exception {
    Recon recon = loadReconContract(getDeployedContracts().get(0), ownerAddress);
    recon.checkout(new BigInteger(bookingId)).sendAsync()
        .get(100000, TimeUnit.MILLISECONDS);
    return getBookingDetails(bookingId);
  }

  public BookingDetailsResponse checkIn(String bookingId) throws Exception {
    Recon recon = loadReconContract(getDeployedContracts().get(0), ownerAddress);
    Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, Boolean> bookingDetails =
        recon.getBookingDetails(new BigInteger(bookingId)).sendAsync()
            .get(100000, TimeUnit.MILLISECONDS);
    if (bookingDetails.component5()) {
      recon.payNowCheckIn(new BigInteger(bookingId)).sendAsync().get(100000, TimeUnit.MILLISECONDS);
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
        .setBookingAmount(Convert.fromWei(response.component2().toString(), Unit.ETHER).toString());
    bookingDetailsResponse.setBookingStatus(BookingStatus.getByValue(
        Integer.valueOf(response.component3().toString())));
    bookingDetailsResponse.setPaymentStatus(PaymentStatus.getByValue(
        Integer.valueOf(response.component4().toString())));
    return bookingDetailsResponse;
  }
}
