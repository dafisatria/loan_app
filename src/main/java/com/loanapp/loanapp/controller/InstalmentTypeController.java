package com.loanapp.loanapp.controller;

import com.loanapp.loanapp.constant.EInstalmentType;
import com.loanapp.loanapp.entity.InstalmentType;
import com.loanapp.loanapp.model.response.CommonResponse;
import com.loanapp.loanapp.service.InstalmentTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/instalment-types")
public class InstalmentTypeController {
    private final InstalmentTypeService instalmentTypeService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'STAFF')")
    public ResponseEntity<CommonResponse<InstalmentType>> createInstalmentType(@RequestBody InstalmentType instalmentType) {
        InstalmentType newInstalmentType = instalmentTypeService.createInstalmentType(instalmentType);
        CommonResponse<InstalmentType> response = CommonResponse.<InstalmentType>builder()
                .message("Succesfully created instalment type")
                .data(newInstalmentType)
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse<InstalmentType>> getInstalmentTypeById(@PathVariable String id) {
        InstalmentType instalmentType = instalmentTypeService.getInstalmentTypeById(id);
        CommonResponse<InstalmentType> response = CommonResponse.<InstalmentType>builder()
                .message("Succesfully retrieved Instalment type")
                .data(instalmentType)
                .build();
        return ResponseEntity.ok(response);
    }
    @GetMapping
    public ResponseEntity<CommonResponse<List<InstalmentType>>> getAllInstalmentType() {
        List<InstalmentType> instalmentTypes = instalmentTypeService.getAllInstalmentTypes();
        CommonResponse<List<InstalmentType>> response = CommonResponse.<List<InstalmentType>>builder()
                .message("Succesfully retrieved Instalment types")
                .data(instalmentTypes)
                .build();
        return ResponseEntity.ok(response);
    }
    @PutMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'STAFF')")
    public ResponseEntity<CommonResponse<InstalmentType>> updateInstalmentType(@RequestBody InstalmentType instalmentType) {
        InstalmentType updateInstalmentType = instalmentTypeService.updateInstalmentType(instalmentType);
        CommonResponse<InstalmentType> response = CommonResponse.<InstalmentType>builder()
                .message("Succesfully updated Instalment types")
                .data(updateInstalmentType)
                .build();
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'STAFF')")
    public ResponseEntity<CommonResponse<String>> deleteInstalmentType(@PathVariable String id) {
        instalmentTypeService.deleteInstalmentType(id);
        CommonResponse<String> response = CommonResponse.<String>builder()
                .message("Succesfully deleted Instalment types")
                .data(id)
                .build();
        return ResponseEntity.ok(response);
    }

}
