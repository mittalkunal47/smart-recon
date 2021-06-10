package com.crypton.smartrecon.service;

import com.crypton.smartrecon.properties.ReconProperties;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.tx.ClientTransactionManager;
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
    loadFactoryContract("0xd00a52657a69388d6050d1e57ef62622f2aaa323")
        .createReconContract(BigInteger.ONE, new BigInteger("2000000000000000"),
            BigInteger.valueOf(70), BigInteger.valueOf(30),
            "0xe706138c3153631411a0d44521d67870ad965e35",
            "0xde094e3b4e014647627599690a2f5ac4f77bf734").sendAsync()
        .get(10000, TimeUnit.MILLISECONDS);
    return "Contract Deployed";
  }

  @SuppressWarnings("unchecked")
  public List<String> getDeployedContracts() throws Exception {
    List<String> contracts = loadFactoryContract("0xd00a52657a69388d6050d1e57ef62622f2aaa323")
        .getDeployedRecons().sendAsync().get(100000, TimeUnit.MILLISECONDS);
    return contracts;
  }

  public String bookHotel() throws Exception {
    Recon recon = loadReconContract(getDeployedContracts().get(0),
        "0xd00a52657a69388d6050d1e57ef62622f2aaa323");
    recon.bookHotel(new BigInteger("200000000000000000")).sendAsync()
        .get(100000, TimeUnit.MILLISECONDS);
    return "bOOked!!:p";
  }

  public String doRecon() throws Exception {
    Recon recon = loadReconContract(getDeployedContracts().get(0),
        "0xd00a52657a69388d6050d1e57ef62622f2aaa323");
    recon.doRecon().sendAsync().get(100000, TimeUnit.MILLISECONDS);
    return "Checkout (:";
  }
}
