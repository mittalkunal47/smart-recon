package com.crypton.smartrecon.service;

import com.crypton.smartrecon.properties.ReconProperties;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import recon.Recon;
import recon.ReconFactory;

public class ReconService {

  private final String contractAddress;

  private final Web3j web3j;

  private final ReconProperties config;

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
    loadFactoryContract().createReconContract(BigInteger.ONE, new BigInteger("2000000000000000"),
        BigInteger.valueOf(70), BigInteger.valueOf(30),
        "0xf5963d0038290f0D66028f66CC95FC2EBA59A2Ca",
        "0x90a5231ad4aB8125A478F0cB5e299bb925e7305b").sendAsync()
        .get(100000, TimeUnit.MILLISECONDS);
    return "Contract Deployed";
  }

  @SuppressWarnings("unchecked")
  public List<String> getDeployedContracts() throws Exception {
    return loadFactoryContract().getDeployedRecons().sendAsync()
        .get(100000, TimeUnit.MILLISECONDS);
  }

  public String payNow(String bookingId, String bookingAmount) throws Exception {
    Recon recon = loadReconContract(getDeployedContracts().get(0), true);
    recon.payNow(new BigInteger(bookingId), new BigInteger(bookingAmount)).sendAsync()
        .get(100000, TimeUnit.MILLISECONDS);
    return "bOOked!!:p";
  }

  public String payLater(String bookingId, String bookingAmount) throws Exception {
    Recon recon = loadReconContract(getDeployedContracts().get(0), true);
    recon.payLater(new BigInteger(bookingId), new BigInteger(bookingAmount)).sendAsync()
        .get(100000, TimeUnit.MILLISECONDS);
    return "bOOked!!:p";
  }

  public Object getBookingDetails(String bookingId) throws Exception {
    Recon recon = loadReconContract(getDeployedContracts().get(0), false);
    return recon.getBookingDetails(new BigInteger(bookingId)).sendAsync()
        .get(100000, TimeUnit.MILLISECONDS);
  }

  public String cancelBooking(String bookingId) throws Exception {
    Recon recon = loadReconContract(getDeployedContracts().get(0), true);
    recon.cancelBooking(new BigInteger(bookingId)).sendAsync().get(100000, TimeUnit.MILLISECONDS);
    return "bOOking Cancelled.. (:";
  }

  public String checkout(String bookingId) throws Exception {
    Recon recon = loadReconContract(getDeployedContracts().get(0), true);
    recon.checkout(new BigInteger(bookingId), new BigInteger("2000000")).sendAsync()
        .get(100000, TimeUnit.MILLISECONDS);
    return "Checkout (:";
  }

  private String getPrivateKey(Boolean customer) {
    if (Boolean.TRUE.equals(customer)) {
      return "909bde7b6fcb97b570c3037f3b7eafb99544c61a4a54960616a4f6358e204059";
    }
    return "79c6a5435ebd62d2a963d504c5fbb8cea80555a9f7f8e9da47c7bd1e2a7f9b58";
  }

}
