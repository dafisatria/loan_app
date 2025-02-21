package com.loanapp.loanapp.model.response;

import com.loanapp.loanapp.constant.LoanStatus;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanTransactionDetailResponse {
    private String id;
    private Long transactionDate;
    private Double nominal;
    private LoanStatus loanStatus;
    private String createdAt;
    private String updatedAt;
}
