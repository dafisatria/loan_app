package com.loanapp.loanapp.config;

import com.loanapp.loanapp.constant.ERole;
import com.loanapp.loanapp.entity.Role;
import com.loanapp.loanapp.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RoleSeeder implements CommandLineRunner {
    private final RoleRepository roleRepository;
    @Override
    public void run(String... args) throws Exception {
        List<Role> existingRoles = roleRepository.findAll();

        List<ERole> defaultRoles = Arrays.asList(ERole.ROLE_CUSTOMER, ERole.ROLE_STAFF, ERole.ROLE_ADMIN);

        for (ERole eRole : defaultRoles) {
            boolean roleExists = existingRoles.stream()
                    .anyMatch(role -> role.getRole().equals(eRole));

            if (!roleExists) {
                roleRepository.save(Role.builder().role(eRole).build());
            }
        }
    }
}
