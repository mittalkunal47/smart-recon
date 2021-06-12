package com.crypton.smartrecon.config;

import com.crypton.smartrecon.properties.ReconProperties;
import com.crypton.smartrecon.service.ReconService;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import recon.ReconFactory;

@Configuration
public class ReconConfig {

  private static final Logger LOG = LoggerFactory.getLogger(ReconConfig.class);

  @Value("${recon.contract.owner-address}")
  private String ownerAddress;

  @Value("${web3j.client-address}")
  private String clientAddress;

  @Autowired
  private ReconProperties config;

  @Bean
  public Web3j web3j() {
    return Web3j.build(new HttpService(clientAddress, new OkHttpClient.Builder().build()));
  }

  @Bean
  public ReconService contract(Web3j web3j)
      throws Exception {
    ReconFactory reconFactory = deployContract(web3j);
    return initReconService(reconFactory.getContractAddress(), web3j);
  }

  private ReconService initReconService(String contractAddress, Web3j web3j) {
    return new ReconService(contractAddress, web3j, config);
  }

  private ReconFactory deployContract(Web3j web3j) throws Exception {
    LOG.info("About to deploy new contract...");
    ReconFactory contract = ReconFactory.deploy(web3j, txManager(web3j), config.gas()).send();
    LOG.info("Deployed new contract with address '{}'", contract.getContractAddress());
    return contract;
  }

  private TransactionManager txManager(Web3j web3j) {
    return new RawTransactionManager(web3j, Credentials.create(getPrivateKey()), 1337);
  }

  private String getPrivateKey() {
    return "79c6a5435ebd62d2a963d504c5fbb8cea80555a9f7f8e9da47c7bd1e2a7f9b58";
  }

}

