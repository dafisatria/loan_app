package com.loanapp.loanapp.repository;

import com.loanapp.loanapp.constant.EInstalmentType;
import com.loanapp.loanapp.entity.Customer;
import com.loanapp.loanapp.entity.InstalmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstalmentTypeRepository extends JpaRepository<InstalmentType, String>{
}
