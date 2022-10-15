package com.example.AccountServices.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        jsr250Enabled = true,
        securedEnabled = true
)
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final JwtFilter jwtFilter;

    private final KeycloakLogoutHandler keycloakLogoutHandler;

    @Bean
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .cors()
//                .and()
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/uaa/**").permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        //https://www.baeldung.com/spring-boot-keycloak
        httpSecurity.authorizeRequests()
                //.antMatchers("/customers*", "/users*")
                //.hasRole("USER")
                .antMatchers("/uaa/**").permitAll()
                .anyRequest()
                .permitAll();
        httpSecurity.oauth2Login()
                .and()
                .logout()
                .addLogoutHandler(keycloakLogoutHandler)
                .logoutSuccessUrl("/");

        httpSecurity.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }
}

