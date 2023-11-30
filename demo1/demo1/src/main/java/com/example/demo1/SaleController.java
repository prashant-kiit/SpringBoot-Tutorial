package com.example.demo1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SaleController {
	@RequestMapping("/")
	public String salesMethod(Sale sale) {
		
		return "salesHomePage";
	}
	
}
