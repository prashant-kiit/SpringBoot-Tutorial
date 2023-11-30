//package com.example.demo2.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@Configuration
//@EnableWebSecurity
//public class Security {
//	
//	// This is still new
//	@Bean
//	public InMemoryUserDetailsManager userDetail() {
//		
//		UserDetails user1=User.builder().username("Prashant").password("{noop}1234").roles("Admin").build();
//		
//		UserDetails user2=User.builder().username("Chinku").password("{noop}0000").roles("Seller").build();
//		
//		UserDetails user3=User.builder().username("Other").password("{bcrypt}4321").roles("Buyer").build();
//		
//		return new InMemoryUserDetailsManager(user1, user2, user3);
//	}
//BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(
//                                    16, new SecureRandom());
//                                    // 16 is the strength here 
//String encodedPassword = encoder.encode("mypassword@4567");
////	
////	// Cannot find any basic authorization code
//}
