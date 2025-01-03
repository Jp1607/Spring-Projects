package com.example.contentcalendar.controller;

import com.example.contentcalendar.model.DTOs.LoginCredentialsDTO;
import com.example.contentcalendar.model.DTOs.RegisterCredentialsDTO;
import com.example.contentcalendar.model.Entities.User;
import com.example.contentcalendar.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginCredentialsDTO credentials) {
        var userNamePassword = new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword());
        var auth = authenticationManager.authenticate(userNamePassword);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterCredentialsDTO registerCredentialsDTO) {
        if (userRepository.findByUsername(registerCredentialsDTO.getUsername()) != null) {
            return ResponseEntity.badRequest().build();
        }
        var encodedPassword = passwordEncoder.encode(registerCredentialsDTO.getPassword());
        User u = new User(registerCredentialsDTO.getUsername(), encodedPassword, registerCredentialsDTO.getRole());
        return ResponseEntity.ok().build();
    }

}
