package com.loanapp.loanapp.service;

import com.loanapp.loanapp.entity.LoanTransactionDetail;

import java.util.List;

public interface LoanTransactionDetailService {
    List<LoanTransactionDetail> createBulk(List<LoanTransactionDetail> loanTransactionDetails);
}
