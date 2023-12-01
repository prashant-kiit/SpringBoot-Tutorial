package com.example.securitydemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfigDemo {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.csrf(csrf -> csrf.disable());
		
		http.formLogin(form -> form.loginPage("/login").permitAll());
		
		http.authorizeHttpRequests((auth) -> auth.anyRequest().authenticated());
		
		return http.build();
		
	}
	
	@Bean
	UserDetailsService userDetailsService() {
		UserDetails prashant = User.builder().
				username("prashant").
				password(passwordEncoder().encode("1234")).
				roles("ADMIN").
				build();
		UserDetails urmila = User.builder().
				username("urmila").
				password(passwordEncoder().encode("6789")).
				roles("USER").
				build();
		
		return new InMemoryUserDetailsManager(prashant, urmila);
	}
	
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
