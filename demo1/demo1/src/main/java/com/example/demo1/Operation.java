package com.example.demo1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

// api=http://localhost:8080/operation?operation=Division&method=modern
@Controller // for web.xml
public class Operation {
	@RequestMapping("/operation") // for web.xml
	public String operationMethod(HttpServletRequest request) {
		System.out.println("This is Operation Controller's operationMethod()");
		// Session begins
		HttpSession session=request.getSession();
		// Accepting the value of parameter to request page and 	
		String paramValue1=request.getParameter("operation");
		String paramValue2=request.getParameter("method");
		// Passing the value of parameter to response page
		session.setAttribute("operation", paramValue1);
		session.setAttribute("method", paramValue2);
		// Call a servelet or JSP
		return "response1"; // auto search in src/main/webapp by springboot
		// Session ends
	}
	
}
