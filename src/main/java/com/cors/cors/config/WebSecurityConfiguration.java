package com.cors.cors.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;



@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration defaultCors = new CorsConfiguration().applyPermitDefaultValues();
        defaultCors.addAllowedOrigin("http://localhost:63342");
        source.registerCorsConfiguration("/**", defaultCors);


        return source;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().permitAll();
        http.cors();
        http.csrf().disable();
    }

       }