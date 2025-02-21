package com.loanapp.loanapp.service;

import com.loanapp.loanapp.constant.EInstalmentType;
import com.loanapp.loanapp.entity.Customer;
import com.loanapp.loanapp.entity.InstalmentType;

import java.util.List;

public interface InstalmentTypeService {
    InstalmentType createInstalmentType(InstalmentType instalmentType);
    InstalmentType getInstalmentTypeById(String id);
    List<InstalmentType> getAllInstalmentTypes();
    InstalmentType updateInstalmentType(InstalmentType instalmentType);
    void deleteInstalmentType(String id);
}
