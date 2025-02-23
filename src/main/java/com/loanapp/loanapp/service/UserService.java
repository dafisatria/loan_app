package com.loanapp.loanapp.service;

import com.loanapp.loanapp.model.request.RegisterRequest;
import com.loanapp.loanapp.model.response.RegisterResponse;

public interface UserService {
    RegisterResponse registerCustomer(RegisterRequest request);
}
