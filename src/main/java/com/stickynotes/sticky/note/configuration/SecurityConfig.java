package com.stickynotes.sticky.note.configuration;

import com.stickynotes.sticky.note.filter.JwtFilter;
import com.stickynotes.sticky.note.service.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity

public class SecurityConfig {

    @Autowired
    private UserDetailsServiceImp userDetailsServiceImp;

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                     // Enables CORS
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/register/**", "/login","/logoutt","/server-health").permitAll()
                        .anyRequest().authenticated());
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class).exceptionHandling(exceptionHandling ->
                exceptionHandling.accessDeniedHandler((request, response, accessDeniedException) -> {
                    // Handle 403 error with custom response
                    response.setStatus(HttpStatus.FORBIDDEN.value());
                    response.getWriter().write("Custom 403 error message");
                })
        );
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}
