package com.bank.creditagencyservice.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class BankResponse {

    @JsonProperty
    private String status;
    @JsonProperty
    private String data;
    @JsonProperty
    private String error;

    public BankResponse(String status, String data, String error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    protected BankResponse(){

    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
