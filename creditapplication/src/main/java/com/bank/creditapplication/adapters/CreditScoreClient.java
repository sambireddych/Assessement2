package com.bank.creditapplication.adapters;

import com.bank.creditapplication.domain.Person;

public interface CreditScoreClient {

    BankResponse getScore(String ssn);
}
