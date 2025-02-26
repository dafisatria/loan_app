package com.loanapp.loanapp.controller;

import com.loanapp.loanapp.entity.User;
import com.loanapp.loanapp.model.request.AuthRequest;
import com.loanapp.loanapp.model.response.CommonResponse;
import com.loanapp.loanapp.model.response.LoginResponse;
import com.loanapp.loanapp.model.response.RegisterResponse;
import com.loanapp.loanapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;

    @PostMapping("/register-customer")
    public ResponseEntity<CommonResponse<RegisterResponse>> registerCustomer(@RequestBody AuthRequest request) {
        RegisterResponse customer = userService.registerCustomer(request);
        CommonResponse<RegisterResponse> response = CommonResponse.<RegisterResponse>builder()
                .message("Successfully created customer account")
                .data(customer)
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<CommonResponse<LoginResponse>> login(@RequestBody AuthRequest request) {
        LoginResponse login = userService.login(request);
        CommonResponse<LoginResponse> response = CommonResponse.<LoginResponse>builder()
                .message("Successfully logged in")
                .data(login)
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register-admin")
    public ResponseEntity<CommonResponse<RegisterResponse>> registerAdmin(@RequestBody AuthRequest request) {
        RegisterResponse admin = userService.registerAdmin(request);
        CommonResponse<RegisterResponse> response = CommonResponse.<RegisterResponse>builder()
                .message("Successfully created admin account")
                .data(admin)
                .build();
        return ResponseEntity.ok(response);
    }
}
