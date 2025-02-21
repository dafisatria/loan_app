package com.loanapp.loanapp.service;

import com.loanapp.loanapp.model.request.LoanTransactionRequest;
import com.loanapp.loanapp.model.response.LoanTransactionResponse;

public interface LoanTransactionService {
    LoanTransactionResponse requestLoan(LoanTransactionRequest loanTransactionRequest);
    LoanTransactionResponse getLoanTransactionsById(String id);
}
