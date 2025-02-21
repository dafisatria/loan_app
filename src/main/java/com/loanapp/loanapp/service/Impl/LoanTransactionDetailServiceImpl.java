package com.loanapp.loanapp.service.Impl;

import com.loanapp.loanapp.entity.LoanTransactionDetail;
import com.loanapp.loanapp.repository.LoanTransactionDetailRepository;
import com.loanapp.loanapp.service.LoanTransactionDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class LoanTransactionDetailServiceImpl implements LoanTransactionDetailService {

    private final LoanTransactionDetailRepository loanTransactionDetailRepository;
    @Override
    public List<LoanTransactionDetail> createBulk(List<LoanTransactionDetail> loanTransactionDetails) {
        return loanTransactionDetailRepository.saveAllAndFlush(loanTransactionDetails);
    }
}
