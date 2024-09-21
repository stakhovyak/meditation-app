package com.weuoimi.user_service.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.weuoimi.user_service.filters.JwtAuthFilter;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;

    @SuppressWarnings("unused")
    private final UserDetailsService userService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // TODO: make sure repuests match
        http
                .cors(cors -> cors.configurationSource(corsConfigurationSource())) 
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> {
                    auth
                        .requestMatchers("/", "/home").permitAll()
                        .requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/profiles").hasAnyAuthority("USER", "ADMIN")
                        .requestMatchers("/swagger-ui/**", "v3/api-docs/**", "swagger-ui.html").permitAll()
                        .anyRequest().authenticated();
                });


        http.exceptionHandling(exHandl -> {
            exHandl.authenticationEntryPoint((request, response, ex) -> {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
            });
        });

        http.sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http/* authenticationProvider(authenticationProvider()) */.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    // @Bean
    // public DaoAuthenticationProvider authenticationProvider() {
        
    //     DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

    //     authProvider.setUserDetailsService(userService);
    //     authProvider.setPasswordEncoder(passwordEncoder());
    //     return authProvider;
    // }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        corsConfiguration.setAllowedOrigins(List.of("*"));
        corsConfiguration.setAllowedMethods(List.of("GET", "PUT", "DELETE", "POST"));
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedHeaders(List.of("*"));
        corsConfiguration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    // @Bean
    // public EmbeddedLdapServerContextSourceFactoryBean contextSourceFactoryBean()
    // {

    // EmbeddedLdapServerContextSourceFactoryBean contextSourceFactoryBean =
    // EmbeddedLdapServerContextSourceFactoryBean.fromEmbeddedLdapServer();

    // contextSourceFactoryBean.setPort(0);
    // return contextSourceFactoryBean;
    // }

    // @Bean
    // AuthenticationManager ldapAuthenticationManager(BaseLdapPathContextSource
    // contextSource) {

    // LdapBindAuthenticationManagerFactory factory =
    // new LdapBindAuthenticationManagerFactory(contextSource);

    // factory.setUserDnPatterns("uid{0}, ou=people");
    // factory.setUserDetailsContextMapper(new PersonContextMapper());
    // return factory.createAuthenticationManager();
    // }

}
