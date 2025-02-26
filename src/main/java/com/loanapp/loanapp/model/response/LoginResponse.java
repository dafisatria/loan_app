package com.loanapp.loanapp.model.response;
import com.loanapp.loanapp.constant.ERole;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class LoginResponse {
    private String email;
    private String token;
    private List<ERole> role;
}
