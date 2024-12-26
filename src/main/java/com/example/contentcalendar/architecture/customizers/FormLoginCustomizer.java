package com.example.contentcalendar.architecture.customizers;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.stereotype.Component;

@Component
public class FormLoginCustomizer implements Customizer<FormLoginConfigurer<HttpSecurity>>{

    @Override
    public void customize(FormLoginConfigurer<HttpSecurity> httpSecurityFormLoginConfigurer) {

        httpSecurityFormLoginConfigurer
                .loginProcessingUrl("/login");
    }
}
