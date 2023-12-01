package com.example.demo1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

// api=http://localhost:8080/music?form=classical&tempo=fast
@Controller
public class Music {
	@RequestMapping("/music") // for web.xml
	public String musicMethod(HttpServletRequest request, HttpSession session) {
		// Session begins
		System.out.println("This is Music Controller's musicMethod()");
		// Accepting the value of parameter to request page and 	
		String paramValue1=request.getParameter("form");
		String paramValue2=request.getParameter("tempo");
		// Passing the value of parameter to response page
		session.setAttribute("form", paramValue1);
		session.setAttribute("tempo", paramValue2);
		// Call a servelet or JSP
		return "response2"; // auto search in src/main/webapp by springboot
		// Session ends
	}
}
