package com.example.demo2.security;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@Configuration
@EnableWebSecurity
public class SecurityDb {
	
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user, pass, enabled from registration where user=?");

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user, role from authority where user=?");
		
		return jdbcUserDetailsManager;
	}
	
	@Bean
    public SecurityFilterChain securityFilterChainMethod(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {

		MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);
        
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(mvcMatcherBuilder.pattern("/susan")).hasRole("ADMIN")
                        .requestMatchers(mvcMatcherBuilder.pattern("/mary")).hasRole("MANAGER")
                        .requestMatchers(mvcMatcherBuilder.pattern("/john")).hasRole("EMPLOYEE")
                        .requestMatchers(mvcMatcherBuilder.pattern("/register")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/roller")).permitAll()
        );
        
        //HeaderWriterLogoutHandler clearSiteData = new HeaderWriterLogoutHandler(new ClearSiteDataHeaderWriter());
        
        http.logout((logout) -> logout.permitAll());
        // https://docs.spring.io/spring-security/reference/servlet/authentication/logout.html#customizing-logout-uris
        
        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());

        return http.build();
        
    }
}
