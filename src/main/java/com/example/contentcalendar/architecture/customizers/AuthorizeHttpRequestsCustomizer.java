package com.example.contentcalendar.architecture.customizers;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.stereotype.Component;

@Component
public class AuthorizeHttpRequestsCustomizer implements Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> {

    @Override
    public void customize(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry httpSecurityAuthorizationManagerRequestMatcherRegistry) {
        httpSecurityAuthorizationManagerRequestMatcherRegistry
                .requestMatchers(HttpMethod.POST, "/login").hasAnyRole()
                .anyRequest().authenticated();
    }
}
