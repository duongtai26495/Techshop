package com.tech.shop.TechShop.configs;


import com.tech.shop.TechShop.entity.AuthenticationRequest;
import com.tech.shop.TechShop.entity.RegisterRequest;
import com.tech.shop.TechShop.entity.Role;
import com.tech.shop.TechShop.entity.User;
import com.tech.shop.TechShop.repository.RoleRepository;
import com.tech.shop.TechShop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final RoleRepository roleRepository;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findByName(Snippets.ROLE_USER));
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(Snippets.TIME_PATTERN);

        var user = User.builder()
                        .id(UUID.randomUUID().toString())
                        .name(request.getName())
                        .email(request.getEmail())
                        .uname(request.getUname())
                        .upw(passwordEncoder.encode(request.getPassword()))
                        .roles(roles)
                        .active(true)
                        .profile_image("")
                        .joined_at(sdf.format(date))
                    .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUname(),
                        request.getPassword()
                )
        );

        var user = userRepository.findByUname(request.getUname())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
