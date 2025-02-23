package com.loanapp.loanapp.repository;

import com.loanapp.loanapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
