package com.loanapp.loanapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.loanapp.loanapp.constant.LoanStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "trx_loan_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanTransactionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "transaction_date")
    private Long transactionDate;
    @Column(name = "nominal")
    private Double nominal;
    @ManyToOne
    @JoinColumn(name = "trx_id", nullable = false)
    @JsonBackReference
    private LoanTransaction loanTransaction;
    @Enumerated(EnumType.STRING)
    @Column(name = "loan_status")
    private LoanStatus loanStatus;
    @Column(name = "created_at")
    private Long createdAt;
    @Column(name = "updated_at")
    private Long updatedAt;
}
