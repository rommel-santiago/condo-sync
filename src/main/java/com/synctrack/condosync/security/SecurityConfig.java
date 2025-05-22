package com.synctrack.condosync.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(authorize -> authorize
            .anyRequest().permitAll() // Allow all requests
        )
        .csrf(csrf -> csrf.disable()) // Disable CSRF
        .headers(headers -> headers.frameOptions().disable()); // Optional: allow H2 console

    return http.build();
  }

}
