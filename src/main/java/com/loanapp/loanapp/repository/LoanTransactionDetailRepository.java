package com.loanapp.loanapp.repository;

import com.loanapp.loanapp.entity.LoanTransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanTransactionDetailRepository extends JpaRepository<LoanTransactionDetail, String> {
}
