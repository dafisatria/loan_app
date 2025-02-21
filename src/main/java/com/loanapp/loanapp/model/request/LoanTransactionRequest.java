package com.loanapp.loanapp.model.request;

import com.loanapp.loanapp.entity.Customer;
import com.loanapp.loanapp.entity.InstalmentType;
import com.loanapp.loanapp.entity.LoanType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanTransactionRequest {
    private LoanType loanType;
    private InstalmentType instalmentType;
    private Customer customer;
    private Double nominal;
}
