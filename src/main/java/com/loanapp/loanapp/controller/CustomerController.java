package com.loanapp.loanapp.controller;

import com.loanapp.loanapp.entity.Customer;
import com.loanapp.loanapp.model.response.CommonResponse;
import com.loanapp.loanapp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse<Customer>> getCustomerById(@PathVariable String id) {
        Customer customer = customerService.getCustomerById(id);
        CommonResponse<Customer> response = CommonResponse.<Customer>builder()
                .message("Successfully retrieved customer")
                .data(customer)
                .build();
        return ResponseEntity.ok(response);
    }
    @GetMapping
    public ResponseEntity<CommonResponse<List<Customer>>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        CommonResponse<List<Customer>> response = CommonResponse.<List<Customer>>builder()
                .message("Successfully retrieved customers")
                .data(customers)
                .build();
        return ResponseEntity.ok(response);
    }
    @PutMapping
    public ResponseEntity<CommonResponse<Customer>> updateCustomer(@RequestBody Customer customer) {
        Customer updatedCustomer = customerService.updateCustomer(customer);
        CommonResponse<Customer> response = CommonResponse.<Customer>builder()
                .message("Successfully updated customer")
                .data(updatedCustomer)
                .build();
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse<String>> deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(id);
        CommonResponse<String> response = CommonResponse.<String>builder()
                .message("Successfully deleted customer")
                .data(id)
                .build();
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<CommonResponse<Customer>> createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.createCustomer(customer);
        CommonResponse<Customer> response = CommonResponse.<Customer>builder()
                .message("Successfully created customer")
                .data(createdCustomer)
                .build();
        return ResponseEntity.ok(response);
    }
}
