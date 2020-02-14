package com.bank.creditagencyservice.service;


import com.bank.creditagencyservice.controller.BankResponse;
import com.bank.creditagencyservice.domain.ApprovalStatus;
import com.bank.creditagencyservice.repository.ApprovalStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditIncreaseCheckService {

    @Autowired
    private ApprovalStatusRepository repository;

    public ApprovalStatus getBySSN(String ssn) throws Exception {
        return repository.getBySsn(ssn);
    }

    public BankResponse checkStatus(String ssn) throws IllegalArgumentException {
        boolean check;
        try {
             check = repository.getBySsn(ssn).isEdibility();
        }catch (IllegalArgumentException e){
            return new BankResponse("Falied","Please give correct SSN",e.getMessage());
        }
        if(check == true){
            return new BankResponse("Approved","Your Score is good enogh to increase Limit",null);
        }
        return new BankResponse("Not Approved","Your Score is too Low to increase Limit",null);
    }

}
