package com.crypton.smartrecon.properties;

import java.math.BigInteger;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.web3j.tx.gas.StaticGasProvider;

@Configuration
@ConfigurationProperties(prefix = "recon.contract")
@Getter
@Setter
public class ReconProperties {

  private BigInteger gasPrice;
  private BigInteger gasLimit;

  public StaticGasProvider gas() {
    return new StaticGasProvider(gasPrice, gasLimit);
  }
}
