package com.example.contentcalendar.architecture.security;

import com.example.contentcalendar.architecture.customizers.FormLoginCustomizer;
import com.example.contentcalendar.architecture.customizers.SessionManagementCustomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    FormLoginCustomizer formLoginCustomizer;
    SessionManagementCustomizer sessionManagementCustomizer;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .csrf().disable()
                .sessionManagement(sessionManagementCustomizer)
                .formLogin(formLoginCustomizer)
                .build();
    }
}
