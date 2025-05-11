package com.loanapp.loanapp.service.Impl;

import com.loanapp.loanapp.entity.*;
import com.loanapp.loanapp.model.request.LoanTransactionRequest;
import com.loanapp.loanapp.model.response.LoanTransactionResponse;
import com.loanapp.loanapp.repository.LoanTransactionRepository;
import com.loanapp.loanapp.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoanTransactionServiceImpl implements LoanTransactionService {
    private final LoanTransactionRepository loanTransactionRepository;
    private final LoanTypeService loanTypeService;
    private final InstalmentTypeService instalmentTypeService;
    private final CustomerService customerService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LoanTransactionResponse requestLoan(LoanTransactionRequest loanTransactionRequest) {
        LoanType loanType = loanTypeService.findLoanTypeById(loanTransactionRequest.getLoanType().getId());
        InstalmentType instalmentType = instalmentTypeService.getInstalmentTypeById(loanTransactionRequest.getInstalmentType().getId());
        Customer customer = customerService.getCustomerById(loanTransactionRequest.getCustomer().getId());

        LoanTransaction loanTransaction = LoanTransaction.builder()
                .loanType(loanType)
                .instalmentType(instalmentType)
                .customer(customer)
                .nominal(loanTransactionRequest.getNominal())
                .build();
        loanTransactionRepository.saveAndFlush(loanTransaction);

        return LoanTransactionResponse.builder()
                .id(loanTransaction.getId())
                .loanTypeId(loanTransaction.getLoanType().getId())
                .instalmentTypeId(loanTransaction.getInstalmentType().getId())
                .customerId(loanTransaction.getCustomer().getId())
                .nominal(loanTransaction.getNominal())
                .createdAt(new Date().toString())
                .build();
    }

    @Override
    public LoanTransactionResponse getLoanTransactionsById(String id) {
        LoanTransaction loanTrx = findByIdOrThrowNotFound(id);
        return LoanTransactionResponse.builder()
                .id(loanTrx.getId())
                .loanTypeId(loanTrx.getLoanType().getId())
                .instalmentTypeId(loanTrx.getInstalmentType().getId())
                .customerId(loanTrx.getCustomer().getId())
                .nominal(loanTrx.getNominal())
                .approvedAt(Optional.ofNullable(loanTrx.getApprovedAt())
                        .map(Object::toString)
                        .orElse("-"))
                .approvedBy(loanTrx.getApprovedBy())
                .approvalStatus(Optional.ofNullable(loanTrx.getApprovalStatus())
                        .map(Object::toString)
                        .orElse("-"))
                .createdAt(Optional.ofNullable(loanTrx.getCreatedAt())
                        .map(Object::toString)
                        .orElse("-"))
                .updatedAt(Optional.ofNullable(loanTrx.getUpdatedAt())
                        .map(Object::toString)
                        .orElse("-"))
                .build();
    }
    public LoanTransaction findByIdOrThrowNotFound(String id) {
        return loanTransactionRepository.findById(id).orElseThrow(() -> new RuntimeException("Instalment type not found"));
    }
}
