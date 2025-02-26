package com.loanapp.loanapp.controller;

import com.loanapp.loanapp.entity.User;
import com.loanapp.loanapp.model.response.CommonResponse;
import com.loanapp.loanapp.model.response.RegisterResponse;
import com.loanapp.loanapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse<RegisterResponse>> getUserById(@PathVariable String id) {
        RegisterResponse user = userService.getUserById(id);
        CommonResponse<RegisterResponse> response = CommonResponse.<RegisterResponse>builder()
                .message("Successfully retrieved user")
                .data(user)
                .build();
        return ResponseEntity.ok(response);
    }
}
