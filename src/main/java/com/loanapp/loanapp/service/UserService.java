package com.loanapp.loanapp.service;

import com.loanapp.loanapp.entity.User;
import com.loanapp.loanapp.model.request.AuthRequest;
import com.loanapp.loanapp.model.response.LoginResponse;
import com.loanapp.loanapp.model.response.RegisterResponse;

public interface UserService {
    RegisterResponse registerCustomer(AuthRequest request);
    LoginResponse login(AuthRequest request);
    RegisterResponse getUserById(String id);
    RegisterResponse registerAdmin(AuthRequest request);
}
