package com.loanapp.loanapp.entity;

import com.loanapp.loanapp.constant.EInstalmentType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_instalment_type")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InstalmentType {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Enumerated(EnumType.STRING)
    @Column(name = "instalment_type", nullable = false, unique = true)
    private EInstalmentType instalmentType;
}
