package com.loanapp.loanapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_loan_type")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanType {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "type", nullable = false)
    private String type;
    @Column(name = "max_loan", nullable = false)
    private Long maxLoan;

}
