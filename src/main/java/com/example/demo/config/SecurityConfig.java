package com.example.demo.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.formLogin(login -> login
					.loginPage("/login").permitAll()
					.defaultSuccessUrl("/manage")
					.usernameParameter("user_id")
					.passwordParameter("password")
					)
			.logout(logout -> logout
					.logoutSuccessUrl("/login?logout").permitAll()
					)
			.authorizeHttpRequests(authz -> authz
					.requestMatchers("/css/**","/error").permitAll()
					.requestMatchers(PathRequest.toStaticResources().atCommonLocations())
					.permitAll()
					.anyRequest().authenticated()
			);
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}