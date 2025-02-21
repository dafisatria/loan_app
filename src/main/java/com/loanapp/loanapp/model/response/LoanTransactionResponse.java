package com.loanapp.loanapp.model.response;

import com.loanapp.loanapp.entity.LoanTransactionDetail;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanTransactionResponse {
    private String id;
    private String loanTypeId;
    private String instalmentTypeId;
    private String customerId;
    private Double nominal;
    private String approvedAt;
    private String approvedBy;
    private String approvalStatus;
    private List<LoanTransactionDetailResponse> loanTransactionDetailResponses;
    private String createdAt;
    private String updatedAt;
}
