package com.keepsafe.backend.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
            .csrf(csrf->csrf.disable())

            .authorizeHttpRequests(auth -> auth
                //anyone can login 
                .requestMatchers(HttpMethod.POST,"/api/auth/register").permitAll()

                //other endpoint need authentication 
                .anyRequest().authenticated()
            );
            return http.build();   
    }
}
