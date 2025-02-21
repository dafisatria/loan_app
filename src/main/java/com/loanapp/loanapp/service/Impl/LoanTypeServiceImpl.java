package com.loanapp.loanapp.service.Impl;

import com.loanapp.loanapp.entity.InstalmentType;
import com.loanapp.loanapp.entity.LoanType;
import com.loanapp.loanapp.repository.InstalmentTypeRepository;
import com.loanapp.loanapp.repository.LoanTypeRepository;
import com.loanapp.loanapp.service.LoanTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanTypeServiceImpl implements LoanTypeService {
    private final LoanTypeRepository loanTypeRepository;

    @Override
    public LoanType createLoanType(LoanType loanType) {
        return loanTypeRepository.saveAndFlush(loanType);
    }

    @Override
    public LoanType findLoanTypeById(String id) {
        return findByIdOrThrowNotFound(id);
    }

    @Override
    public List<LoanType> findAll() {
        return loanTypeRepository.findAll();
    }

    @Override
    public LoanType updateLoanType(LoanType loanType) {
        findByIdOrThrowNotFound(loanType.getId());
        return loanTypeRepository.saveAndFlush(loanType);
    }

    @Override
    public void deleteLoanTypeById(String id) {
        loanTypeRepository.deleteById(id);
    }
    public LoanType findByIdOrThrowNotFound(String id) {
        return loanTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("Instalment type not found"));
    }
}
