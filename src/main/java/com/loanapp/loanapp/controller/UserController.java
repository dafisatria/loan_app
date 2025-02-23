package com.loanapp.loanapp.controller;

import com.loanapp.loanapp.model.request.RegisterRequest;
import com.loanapp.loanapp.model.response.CommonResponse;
import com.loanapp.loanapp.model.response.RegisterResponse;
import com.loanapp.loanapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class UserController {
    private final UserService userService;

    @PostMapping("/register-customer")
    public ResponseEntity<CommonResponse<RegisterResponse>> register(@RequestBody RegisterRequest request) {
        RegisterResponse customer = userService.registerCustomer(request);
        CommonResponse<RegisterResponse> response = CommonResponse.<RegisterResponse>builder()
                .message("Successfully created customer account")
                .data(customer)
                .build();
        return ResponseEntity.ok(response);
    }
}
