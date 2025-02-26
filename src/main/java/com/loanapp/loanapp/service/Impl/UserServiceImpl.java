package com.loanapp.loanapp.service.Impl;

import com.loanapp.loanapp.constant.ERole;
import com.loanapp.loanapp.entity.Customer;
import com.loanapp.loanapp.entity.Role;
import com.loanapp.loanapp.entity.User;
import com.loanapp.loanapp.model.request.AuthRequest;
import com.loanapp.loanapp.model.response.LoginResponse;
import com.loanapp.loanapp.model.response.RegisterResponse;
import com.loanapp.loanapp.repository.RoleRepository;
import com.loanapp.loanapp.repository.UserRepository;
import com.loanapp.loanapp.security.JwtTokenProvider;
import com.loanapp.loanapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public RegisterResponse registerCustomer(AuthRequest request) {
        Role roleCustomer = roleRepository.findByRole(ERole.ROLE_CUSTOMER);
        List<Role> roles = new ArrayList<>();
        roles.add(roleCustomer);

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(roles)
                .build();
        userRepository.saveAndFlush(user);
        return RegisterResponse.builder()
                .email(user.getEmail())
                .role(user.getRoles().stream().map(Role::getRole).toList())
                .build();
    }

    @Override
    public LoginResponse login(AuthRequest request) {
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid email or password"));
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid password");
        }
        String token = jwtTokenProvider.generateToken(user.getEmail(), user.getRoles().stream().map(Role::getRole).toList());
        return LoginResponse.builder()
                .email(user.getEmail())
                .role(user.getRoles().stream().map(Role::getRole).toList())
                .token(token)
                .build();
    }

    @Override
    public RegisterResponse getUserById(String id) {
        User user = findByIdOrThrowNotFound(id);
        return RegisterResponse.builder()
                .email(user.getEmail())
                .role(user.getRoles().stream().map(Role::getRole).toList())
                .build();
    }

    @Override
    public RegisterResponse registerAdmin(AuthRequest request) {
        Role roleAdmin = roleRepository.findByRole(ERole.ROLE_ADMIN);
        Role roleStaff = roleRepository.findByRole(ERole.ROLE_STAFF);
        List<Role> roles = new ArrayList<>();
        roles.add(roleAdmin);
        roles.add(roleStaff);

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(roles)
                .build();
        userRepository.saveAndFlush(user);
        return RegisterResponse.builder()
                .email(user.getEmail())
                .role(user.getRoles().stream().map(Role::getRole).toList())
                .build();
    }

    public User findByIdOrThrowNotFound(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
