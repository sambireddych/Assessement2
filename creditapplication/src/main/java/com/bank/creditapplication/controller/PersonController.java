package com.bank.creditapplication.controller;


import com.bank.creditapplication.adapters.BankResponse;
import com.bank.creditapplication.adapters.CreditScoreClient;
import com.bank.creditapplication.domain.Person;
import com.bank.creditapplication.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/person")
@Api(tags = "BankApplication")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private CreditScoreClient client;



    @ApiOperation(value = "List of persons")
    @GetMapping
    public ResponseEntity<Stream<Person>> get(){
        return new ResponseEntity<>(personService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Person> get(@PathVariable long id) throws Exception {
        return new ResponseEntity<>(personService.getPerson(id), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Check eligible status by giving Valid SSN")
    @GetMapping(params = "ssn")
    public ResponseEntity<BankResponse> checkEligible(String ssn){

       BankResponse response= client.getScore(ssn);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
