///*
// * Copyright (c) 2023, TopS BI LLC. All rights reserved.
// * http://www.topsbi.ru
// */
//
//package az.namazov.bookkeeping.config.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//@Configuration
//@EnableWebSecurity
//@Order(1)
//public class Security {
//
//    @Bean
//    protected SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {
//        return http
//                .csrf().disable()
//                .cors().disable()
//                .authorizeHttpRequests(auth ->
//                        auth
//                                .anyRequest().authenticated()
//                )
//                .httpBasic(Customizer.withDefaults())
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .build();
//    }
//
//    @Bean
//    protected PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(4);
//    }
//
//    @Bean
//    protected UserDetailsService userDetailsService(final PasswordEncoder passwordEncoder) {
//        return new InMemoryUserDetailsManager(
//                User.builder()
//                        .username("test")
//                        .password("test")
//                        .passwordEncoder(passwordEncoder::encode)
//                        .roles("ADMIN")
//                        .build()
//        );
//    }
//}
