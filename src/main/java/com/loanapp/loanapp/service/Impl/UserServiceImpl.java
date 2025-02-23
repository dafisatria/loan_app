package com.loanapp.loanapp.service.Impl;

import com.loanapp.loanapp.constant.ERole;
import com.loanapp.loanapp.entity.Role;
import com.loanapp.loanapp.entity.User;
import com.loanapp.loanapp.model.request.RegisterRequest;
import com.loanapp.loanapp.model.response.RegisterResponse;
import com.loanapp.loanapp.repository.RoleRepository;
import com.loanapp.loanapp.repository.UserRepository;
import com.loanapp.loanapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public RegisterResponse registerCustomer(RegisterRequest request) {
        Role roleCustomer = roleRepository.findByRole(ERole.ROLE_CUSTOMER);
        List<Role> roles = new ArrayList<>();
        roles.add(roleCustomer);

        User user  = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(roles)
                .build();
        userRepository.save(user);
        return RegisterResponse.builder()
                .email(user.getEmail())
                .role(user.getRoles().stream().map(Role::getRole).toList())
                .build();
    }
}
