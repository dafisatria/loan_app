package com.loanapp.loanapp.service.Impl;

import com.loanapp.loanapp.entity.Customer;
import com.loanapp.loanapp.entity.InstalmentType;
import com.loanapp.loanapp.repository.InstalmentTypeRepository;
import com.loanapp.loanapp.service.InstalmentTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class InstalmentTypeServiceImpl implements InstalmentTypeService {
    private final InstalmentTypeRepository instalmentTypeRepository;

    @Override
    public InstalmentType createInstalmentType(InstalmentType instalmentType) {
        return instalmentTypeRepository.saveAndFlush(instalmentType);
    }

    @Override
    public InstalmentType getInstalmentTypeById(String id) {
        return findByIdOrThrowNotFound(id);
    }

    @Override
    public List<InstalmentType> getAllInstalmentTypes() {
        return instalmentTypeRepository.findAll();
    }

    @Override
    public InstalmentType updateInstalmentType(InstalmentType instalmentType) {
        InstalmentType byIdOrThrowNotFound = findByIdOrThrowNotFound(instalmentType.getId());
        instalmentType.setInstalmentType(byIdOrThrowNotFound.getInstalmentType());
        return instalmentTypeRepository.saveAndFlush(instalmentType);
    }

    @Override
    public void deleteInstalmentType(String id) {
        instalmentTypeRepository.deleteById(id);
    }
    public InstalmentType findByIdOrThrowNotFound(String id) {
        return instalmentTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("Instalment type not found"));
    }
}
