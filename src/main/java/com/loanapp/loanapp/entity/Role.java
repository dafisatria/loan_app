package com.loanapp.loanapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "m_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "role")
    private String role; // Enum
}
