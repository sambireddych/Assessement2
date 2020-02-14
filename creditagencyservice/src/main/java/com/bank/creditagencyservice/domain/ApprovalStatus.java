package com.bank.creditagencyservice.domain;

public class ApprovalStatus {

    private long id;
    private String ssn;
    private boolean edibility;

    public ApprovalStatus(long id, String ssn, boolean edibility) {
        this.ssn = ssn;
        this.edibility = edibility;
        this.id = id;
    }

    protected ApprovalStatus(){}
    public String getSsn() {
        return ssn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public boolean isEdibility() {
        return edibility;
    }

    public void setEdibility(boolean edibility) {
        this.edibility = edibility;
    }
}
