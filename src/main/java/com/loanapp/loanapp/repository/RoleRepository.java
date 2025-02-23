package com.loanapp.loanapp.repository;

import com.loanapp.loanapp.constant.ERole;
import com.loanapp.loanapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(ERole role);
}
