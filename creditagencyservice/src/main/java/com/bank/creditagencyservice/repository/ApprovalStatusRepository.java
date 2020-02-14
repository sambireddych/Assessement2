package com.bank.creditagencyservice.repository;

import com.bank.creditagencyservice.domain.ApprovalStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class ApprovalStatusRepository {


    private static final List<ApprovalStatus> creditCheckStore = new ArrayList<>();

    static {
        creditCheckStore.add(new ApprovalStatus(1L, "098-38-2992", true));
        creditCheckStore.add(new ApprovalStatus(2L, "087-99-8754", false));
        creditCheckStore.add(new ApprovalStatus(3L, "023-24-5765", false));
        creditCheckStore.add(new ApprovalStatus(4L, "023-22-3365", true));
    }


    public ApprovalStatus getBySsn(String ssn) throws IllegalArgumentException {
        ApprovalStatus status = null;
        try {
            status = creditCheckStore.stream().filter(approvalStatus -> approvalStatus.getSsn().equals(ssn))
                    .findFirst().get();
        } catch (IllegalArgumentException ie) {
            throw new IllegalArgumentException(ie.getMessage());
        }
        return status;
    }

    private List<Long> findAll() {
        return creditCheckStore.stream().map(ApprovalStatus::getId).collect(Collectors.toList());
    }


}
