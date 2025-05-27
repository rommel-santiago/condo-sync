package com.synctrack.condosync.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


    http
        .csrf(AbstractHttpConfigurer::disable)
        .sessionManagement(
            session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))

        // Require authentication for all requests under /condo-sync/**
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/", "/login**", "/css/**", "/js/**", "/images/**").permitAll()
            .anyRequest().authenticated()
        )

        // Allow OAuth2 login
        .oauth2Login(Customizer.withDefaults())

        //Allow h2-console
        .headers( headers -> headers.frameOptions(FrameOptionsConfig::disable));



    return http.build();
  }







}
