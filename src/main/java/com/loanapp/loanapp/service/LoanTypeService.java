package com.loanapp.loanapp.service;

import com.loanapp.loanapp.entity.LoanType;

import java.util.List;

public interface LoanTypeService {
    LoanType createLoanType(LoanType loanType);
    LoanType findLoanTypeById(String id);
    List<LoanType> findAll();
    LoanType updateLoanType(LoanType loanType);
    void deleteLoanTypeById(String id);
}
