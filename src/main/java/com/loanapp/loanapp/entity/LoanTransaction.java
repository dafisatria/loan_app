package com.loanapp.loanapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.loanapp.loanapp.constant.ApprovalStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "trx_loan")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne
    @JoinColumn(name = "loan_type_id")
    @JsonBackReference
    private LoanType loanType;
    @ManyToOne
    @JoinColumn(name = "instalment_type_id")
    @JsonBackReference
    private InstalmentType instalmentType;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private Customer customer;
    @Column(name = "nominal")
    private Double nominal;
    @Column(name = "approved_at")
    private Long approvedAt;
    @Column(name = "approved_by")
    private String approvedBy;
    @Enumerated(EnumType.STRING)
    @Column(name = "approval_status")
    private ApprovalStatus approvalStatus;
    @OneToMany
    @JsonBackReference
    private List<LoanTransactionDetail> loanTransactionDetails;
    @Column(name = "created_at")
    private Long createdAt;
    @Column(name = "updated_at")
    private Long updatedAt;
}
