package com.loanapp.loanapp.model.response;

import com.loanapp.loanapp.constant.ERole;
import com.loanapp.loanapp.entity.Role;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterResponse {
    private String email;
    private List<ERole> role;
}