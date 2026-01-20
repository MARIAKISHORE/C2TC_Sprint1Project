package com.devmart.customerorbitservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class CustomerSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // Disable CSRF for REST APIs
            .csrf(csrf -> csrf.disable())

            // Authorization rules
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/customers/**").permitAll()
                .requestMatchers("/orders/**").permitAll()
                .anyRequest().authenticated()
            )

            // Disable default login form
            .formLogin(form -> form.disable())

            // Disable basic auth popup
            .httpBasic(basic -> basic.disable());

        return http.build();
    }
}
