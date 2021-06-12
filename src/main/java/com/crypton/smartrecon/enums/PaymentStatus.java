package com.crypton.smartrecon.enums;

public enum PaymentStatus {
  PAID("paid",0),
  UNPAID("unpaid",1),
  REFUNDED("refunded", 2);


  private String status;

  private Integer statusValue;

  PaymentStatus(String status, Integer statusValue) {
    this.status = status;
    this.statusValue = statusValue;
  }

  public static PaymentStatus getByValue(Integer statusValue) {
    for (PaymentStatus paymentStatus : PaymentStatus.values()) {
      if (paymentStatus.statusValue.equals(statusValue)){
        return paymentStatus;
      }
    }
    return null;
  }
}
