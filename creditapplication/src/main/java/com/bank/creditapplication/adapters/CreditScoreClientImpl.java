package com.bank.creditapplication.adapters;

import com.bank.creditapplication.domain.Person;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class CreditScoreClientImpl implements CreditScoreClient {

    private RestTemplate restTemplate;
    private PersonConfig config;

    public CreditScoreClientImpl(PersonConfig config, RestTemplateBuilder restTemplateBuilder) {
        this.config = config;
        this.restTemplate = restTemplateBuilder
                .setConnectTimeout(Duration.ofSeconds(30))
                .setReadTimeout(Duration.ofSeconds(30))
                .build();
    }

    @Retryable(maxAttempts = 3,
            backoff = @Backoff(delay = 100, maxDelay = 2000, random = true))
    @HystrixCommand(groupKey = "creditagencyservice",
            commandKey = "checkEligible",
            fallbackMethod = "fallBackMethod")
    @Override
    public BankResponse getScore(String ssn) {
        String url = "http://localhost:8067/creditlimit/response?ssn="+ssn;
        ResponseEntity<BankResponse> model;
        model = restTemplate.getForEntity(
                url,
                BankResponse.class);
//        config.getUrl() + "/creditlimit/response?ssn="+ssn
        return model.getBody();
    }

    private BankResponse fallBackMethod(String ssn){
        throw  new RuntimeException("Server Error at this time, please try again later");
    }

}
