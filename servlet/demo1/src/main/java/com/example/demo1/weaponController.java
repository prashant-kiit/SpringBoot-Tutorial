package com.example.demo1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// api=http://localhost:8080/weapon?id=1&name=AK47&caliber=3.1
@Controller
public class weaponController {
	@RequestMapping("/weapon")
	public ModelAndView weaponMethod(Weapon weapon) {
		System.out.println("Check");
		ModelAndView modelAndView=new ModelAndView(); // input data model object
		modelAndView.addObject("weapon", weapon);
		modelAndView.setViewName("responseWeapon");
		return modelAndView; 
	}
}
