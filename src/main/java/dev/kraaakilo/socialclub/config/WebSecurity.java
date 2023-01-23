package dev.kraaakilo.socialclub.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class WebSecurity {
    public final JWTAuthenticationFilter jwtAuthenticationFilter;
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().ignoringRequestMatchers("/api/**").and()
                .authorizeHttpRequests(
                        requests -> requests
                                .requestMatchers("/api/v1/auth", "/api/v1/auth/**")
                                .authenticated()
                                .requestMatchers("/api/v1/login","/api/v1/register")
                                .permitAll()
                                .anyRequest()
                                .permitAll()
                )
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin(form ->form.loginPage("/unauthenticated"));

        return httpSecurity.httpBasic().and().build();
    }
}
