package com.example.demo1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// api=http://localhost:8080/techy?tech=springboot&version=3.1
@Controller
public class TechController {
	@RequestMapping("/techy")
	public ModelAndView techMethod(@RequestParam(value = "tech")String tech, @RequestParam(value = "version")String version) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("tech", tech);
		modelAndView.addObject("version", version);
		modelAndView.setViewName("responseTech");
		return modelAndView;
	}
}
