package com.crypton.smartrecon.controller;

import com.crypton.smartrecon.service.ReconService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

  @PostMapping(value = "/book", produces = {"application/json"})
  public @ResponseBody
  String bookHotel() throws Exception {
    return reconService.bookHotel();
  }

  @PostMapping(value = "/checkout", produces = {"application/json"})
  public @ResponseBody
  String doRecon() throws Exception {
    return reconService.doRecon();
  }

}
