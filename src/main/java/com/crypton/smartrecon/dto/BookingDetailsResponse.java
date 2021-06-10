package com.crypton.smartrecon.dto;

import com.crypton.smartrecon.enums.BookingStatus;
import com.crypton.smartrecon.enums.PaymentStatus;
import lombok.Data;

@Data
public class BookingDetailsResponse {

  String bookingId;
  String bookingAmount;
  BookingStatus bookingStatus;
  PaymentStatus paymentStatus;
}
