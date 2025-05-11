package com.loanapp.loanapp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.loanapp.loanapp.constant.ERole;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "m_role")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private ERole role;

    @ManyToMany(mappedBy = "roles")
    @JsonManagedReference
    private List<User> users;

}
