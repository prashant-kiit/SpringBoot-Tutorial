//package com.example.demo2.security;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
////import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
//import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
//
//// Ignore this. This is old.
//// Traditional MVC Security
//@Configuration
//@EnableWebSecurity
//public class SecurityConfigMvcOld {
//	
//	// This is still new
//	@Bean
//	public InMemoryUserDetailsManager userDetails() {
//		
//		UserDetails user1=User.builder().username("Prashant").password("{noop}1234").roles("Admin").build();
//		
//		UserDetails user2=User.builder().username("Chinku").password("{noop}0000").roles("Seller").build();
//		
//		UserDetails user3=User.builder().username("Other").password("{noop}4321").roles("Buyer").build();
//		
//		return new InMemoryUserDetailsManager(user1, user2, user3);
//	}
//	
//	@Bean
//    public SecurityFilterChain securityFilterChainMethod(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
//		//https://spring.io/security/cve-2023-34035
//		//https://spring.io/guides/gs/securing-web/
//		//https://docs.spring.io/spring-security/reference/servlet/integrations/mvc.html#
//		//To use MvcRequestMatcher, you must place the Spring Security Configuration 
//		//in the same ApplicationContext as your DispatcherServlet
//		//this means that you should place your configuration 
//		//in the DispatcherServlet tag of web.xml
//
//		MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);
//        http.authorizeHttpRequests(configurer ->
//                configurer
//                        .requestMatchers(mvcMatcherBuilder.pattern("/home")).hasRole("Seller")
//                        .requestMatchers(mvcMatcherBuilder.pattern("/add")).hasRole("Buyer")
//                        .requestMatchers(mvcMatcherBuilder.pattern("/delete")).hasRole("Admin")
//                        .requestMatchers(mvcMatcherBuilder.pattern("/sale/**")).hasRole("Admin")
//        );
//
//        // use HTTP Basic authentication
//        http.httpBasic(Customizer.withDefaults());
//
//        // disable Cross Site Request Forgery (CSRF)
//        // in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
//        http.csrf(csrf -> csrf.disable());
//
//        return http.build();
//    }
//}
