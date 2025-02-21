package com.loanapp.loanapp.controller;

import com.loanapp.loanapp.entity.LoanType;
import com.loanapp.loanapp.model.response.CommonResponse;
import com.loanapp.loanapp.service.LoanTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/loan-types")
public class LoanTypeController {
    private final LoanTypeService loanTypeService;

    @PostMapping
    public ResponseEntity<CommonResponse<LoanType>> createLoanType(@RequestBody LoanType loanType) {
        LoanType newLoanType = loanTypeService.createLoanType(loanType);
        CommonResponse<LoanType> response = CommonResponse.<LoanType>builder()
                .message("Successfully created loan type")
                .data(newLoanType)
                .build();
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse<LoanType>> getLoanTypeById(@PathVariable String id) {
        LoanType loanType = loanTypeService.findLoanTypeById(id);
        CommonResponse<LoanType> response = CommonResponse.<LoanType>builder()
                .message("Successfully retrieved loan type")
                .data(loanType)
                .build();
        return ResponseEntity.ok(response);
    }
    @GetMapping
    public ResponseEntity<CommonResponse<List<LoanType>>> getAllLoanTypes() {
        List<LoanType> loanTypes = loanTypeService.findAll();
        CommonResponse<List<LoanType>> response = CommonResponse.<List<LoanType>>builder()
                .message("Successfully retrieved loan types")
                .data(loanTypes)
                .build();
        return ResponseEntity.ok(response);
    }
    @PutMapping
    public ResponseEntity<CommonResponse<LoanType>> updateLoanType(@RequestBody LoanType loanType) {
        LoanType updatedLoanType = loanTypeService.updateLoanType(loanType);
        CommonResponse<LoanType> response = CommonResponse.<LoanType>builder()
                .message("Successfully updated loan type")
                .data(updatedLoanType)
                .build();
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse<String>> deleteLoanTypeById(@PathVariable String id) {
        loanTypeService.deleteLoanTypeById(id);
        CommonResponse<String> response = CommonResponse.<String>builder()
                .message("Successfully deleted loan type")
                .data(id)
                .build();
        return ResponseEntity.ok(response);
    }
}
