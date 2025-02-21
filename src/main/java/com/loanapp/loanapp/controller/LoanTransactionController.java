package com.loanapp.loanapp.controller;

import com.loanapp.loanapp.model.request.LoanTransactionRequest;
import com.loanapp.loanapp.model.response.CommonResponse;
import com.loanapp.loanapp.model.response.LoanTransactionResponse;
import com.loanapp.loanapp.service.LoanTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transactions")
public class LoanTransactionController {
    private final LoanTransactionService loanTransactionService;

    @PostMapping
    public ResponseEntity<CommonResponse<LoanTransactionResponse>> create(@RequestBody LoanTransactionRequest loanTransactionRequest) {
        LoanTransactionResponse loanTransactionResponse = loanTransactionService.requestLoan(loanTransactionRequest);
        CommonResponse<LoanTransactionResponse> response =  CommonResponse.<LoanTransactionResponse>builder()
                .message("Successfully created loan transaction")
                .data(loanTransactionResponse)
                .build();
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse<LoanTransactionResponse>> get(@PathVariable String id) {
        LoanTransactionResponse loanTransactionResponse = loanTransactionService.getLoanTransactionsById(id);
        CommonResponse<LoanTransactionResponse> response =  CommonResponse.<LoanTransactionResponse>builder()
                .message("Successfully retrieved loan transaction")
                .data(loanTransactionResponse)
                .build();
        return ResponseEntity.ok(response);
    }
}
