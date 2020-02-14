package com.bank.creditagencyservice.controller;


import com.bank.creditagencyservice.service.CreditIncreaseCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/creditlimit")
public class CreditAgencyServiceController {

    @Autowired
    private CreditIncreaseCheckService service;


    @GetMapping(params = "ssn")
    public ResponseEntity<Boolean> get(@RequestParam String ssn) throws Exception {
        boolean check = service.getBySSN(ssn).isEdibility();
        return new ResponseEntity<>(check, HttpStatus.OK);

    }

    @GetMapping(path="/response",params = "ssn")
    public ResponseEntity<BankResponse> check(@RequestParam String ssn) throws Exception {
        BankResponse bankResponse = service.checkStatus(ssn);
        return new ResponseEntity<>(bankResponse, HttpStatus.OK);

    }

}
