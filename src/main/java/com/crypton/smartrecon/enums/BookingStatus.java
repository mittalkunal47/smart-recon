package com.crypton.smartrecon.enums;

public enum BookingStatus {

  CONFIRMED("confirmed", 0),
  CHECKED_IN("checked_in", 1),
  CHECKED_OUT("checked_out", 2),
  CANCELLED("cancelled", 3);

  private String status;

  private Integer statusValue;

  BookingStatus(String status, Integer statusValue) {
    this.status = status;
    this.statusValue = statusValue;
  }

  public static BookingStatus getByValue (Integer statusValue) {
    for (BookingStatus bookingStatus : BookingStatus.values()) {
      if (bookingStatus.statusValue.equals(statusValue)) {
        return bookingStatus;
      }
    }
    return null;
  }


}
