package com.crypton.smartrecon.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.crypton.smartrecon.dto.BookingDetailsResponse;
import com.crypton.smartrecon.service.ReconService;

@Controller
public class ReconController {

  private final ReconService reconService;

  @Autowired
  public ReconController(ReconService reconService) {
    this.reconService = reconService;
  }

  @GetMapping(value = "/get_balance")
  public String getContractBalance() throws IOException {
    return reconService.getBalance().toString();
  }

  @PostMapping(value = "/create_contract", produces = {"application/json"})
  public @ResponseBody
  String createReconContract() throws Exception {
    return reconService.createReconContract();
  }

  @GetMapping(value = "/get_all", produces = {"application/json"})
  public @ResponseBody
  List<String> getDeployedContracts() throws Exception {
    return reconService.getDeployedContracts();
  }

  @PostMapping(value = "/pay_now", produces = {"application/json"})
  public @ResponseBody
  BookingDetailsResponse payNow(@RequestParam("booking_id") String bookingId,
      @RequestParam("booking_amount") String bookingAmount) throws Exception {
    return reconService.payNow(bookingId, bookingAmount);
  }

  @PostMapping(value = "/pay_later", produces = {"application/json"})
  public @ResponseBody
  BookingDetailsResponse payLater(@RequestParam("booking_id") String bookingId,
      @RequestParam("booking_amount") String bookingAmount) throws Exception {
    return reconService.payLater(bookingId, bookingAmount);
  }

  @GetMapping(value = "/details", produces = {"application/json"})
  public @ResponseBody
  BookingDetailsResponse getBookingDetails(@RequestParam("booking_id") String bookingId)
      throws Exception {
    return reconService.getBookingDetails(bookingId);
  }

  @GetMapping(value = "/all_bookings", produces = {"application/json"})
  public @ResponseBody
  List<BookingDetailsResponse> getAllBookings()
      throws Exception {
    return reconService.getAllBookings();
  }

  @PostMapping(value = "/update_booking", produces = {"application/json"})
  public @ResponseBody
  BookingDetailsResponse update(@RequestParam("booking_id") String bookingId,
      @RequestParam String action) throws Exception {
    if (action.equalsIgnoreCase("cancel")) {
      return reconService.cancelBooking(bookingId);
    } else if (action.equalsIgnoreCase("checkin")) {
      return reconService.checkIn(bookingId);
    } else if (action.equalsIgnoreCase("checkout")) {
      return reconService.checkout(bookingId);
    }
    return null;
  }
}
