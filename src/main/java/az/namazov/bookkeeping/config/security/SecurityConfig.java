package az.namazov.bookkeeping.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import az.namazov.bookkeeping.config.security.jwt.JwtTokenProvider;
import az.namazov.bookkeeping.config.security.jwt.JwtUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;
    private final CustomAuthenticationProvider customAuthenticationProvider;
    private final JwtUserDetailsService jwtUserDetailsService;

    private static final String ADMIN_ENDPOINT = "/admin/**";
    private static final String LOGIN_ENDPOINT = "/v1/login";


    public SecurityConfig(@Autowired JwtTokenProvider jwtTokenProvider,
            @Autowired CustomAuthenticationProvider customAuthenticationProvider,
            @Autowired JwtUserDetailsService jwtUserDetailsService) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.customAuthenticationProvider = customAuthenticationProvider;
        this.jwtUserDetailsService = jwtUserDetailsService;
    }

    @Bean
    protected SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//                .addFilterBefore(new JwtTokenFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class)
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers(LOGIN_ENDPOINT).permitAll()
//                        .requestMatchers(ADMIN_ENDPOINT).hasRole("ADMIN")
//                        .anyRequest().authenticated())
//                .apply(new JwtConfigurer(jwtTokenProvider));
        return http.build();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
//        AuthenticationManagerBuilder authenticationManagerBuilder =
//                http.getSharedObject(AuthenticationManagerBuilder.class);
//        authenticationManagerBuilder.authenticationProvider(customAuthenticationProvider);
//        authenticationManagerBuilder.userDetailsService(jwtUserDetailsService);
//        return authenticationManagerBuilder.build();
        return  http.getSharedObject(AuthenticationManagerBuilder.class).build();
    }
}