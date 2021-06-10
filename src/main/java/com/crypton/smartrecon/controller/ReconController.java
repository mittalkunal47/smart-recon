package com.crypton.smartrecon.controller;

import com.crypton.smartrecon.service.ReconService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    return reconService.CreateReconContract();
  }

  @GetMapping(value = "/get_all", produces = {"application/json"})
  public @ResponseBody
  List<String> getDeployedContracts() throws Exception {
    return reconService.getDeployedContracts();
  }

  @PostMapping(value = "/pay_now", produces = {"application/json"})
  public @ResponseBody
  String payNow(@RequestParam("booking_id") String bookingId,
      @RequestParam("booking_amount") String bookingAmount) throws Exception {
    return reconService.payNow(bookingId, bookingAmount);
  }

  @PostMapping(value = "/pay_later", produces = {"application/json"})
  public @ResponseBody
  String payLater(@RequestParam("booking_id") String bookingId,
      @RequestParam("booking_amount") String bookingAmount) throws Exception {
    return reconService.payLater(bookingId, bookingAmount);
  }

  @GetMapping(value = "/details", produces = {"application/json"})
  public @ResponseBody
  Object bookingDetails(@RequestParam("booking_id") String bookingId) throws Exception {
    return reconService.getBookingDetails(bookingId);
  }

  @PostMapping(value = "/checkout", produces = {"application/json"})
  public @ResponseBody
  String checkout(@RequestParam("booking_id") String bookingId) throws Exception {
    return reconService.checkout(bookingId);
  }

  @PostMapping(value = "/cancel", produces = {"application/json"})
  public @ResponseBody
  String cancel(@RequestParam("booking_id") String bookingId) throws Exception {
    return reconService.cancelBooking(bookingId);
  }

}
