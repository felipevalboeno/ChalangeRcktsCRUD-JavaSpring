package com.crudcursos.felipevalboeno.crudcursos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    private static final String[] PERMIT_ALL_LIST = {
        "/swagger-ui/**",
        "/swagger-ui.html",
        "/v3/api-docs/**",
        "/swagger-resources/**",
        "/swagger-resources/configuration/ui",
        "/swagger-resources/configuration/security",
        "/webjars/**",
        "/actuator/**"

    };

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())  // desabilita CSRF
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(PERMIT_ALL_LIST).permitAll()
                //.requestMatchers("/cursos").permitAll()   // libera todas as URLs da lista
                .anyRequest().permitAll()                      // libera qualquer outra URL
            );

        return http.build();
    }
}
