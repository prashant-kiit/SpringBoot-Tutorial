package com.example.securitydemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

@Controller
public class SecurityController {

	@GetMapping("/login")
	public String login() {
		System.out.println("login function!!!");
		return "login-page";
	}
	
    @GetMapping("/")
    @ResponseBody
    public String dashboard() {
        return "dashboard";
    }
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/admin-hello")
	@ResponseBody
	public String helloAdmin() {
		return "Hello Admin!";
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/user-hello")
	@ResponseBody
	public String helloUser() {
		return "Hello User!";
	}
}
