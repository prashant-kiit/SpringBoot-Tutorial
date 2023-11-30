package com.example.demo2.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo2.dto.SaleDto;
import com.example.demo2.entityDAO.Sale;
import com.example.demo2.repository.SaleRepo;
import com.example.demo2.security.AuthRepo;
import com.example.demo2.security.Authority;
import com.example.demo2.security.RegisterRepo;
import com.example.demo2.security.Registration;
import com.example.demo2.service.ServiceInterface;

@Controller
public class SaleController {
	
	@Autowired
	SaleRepo saleRepo;
	
	@Autowired
	ServiceInterface service;
	
	@Autowired
	private ModelMapper modelMapper;
//	
	@Autowired
	private RegisterRepo registerRepo;

	@Autowired
	private AuthRepo authRepo;
	
	@RequestMapping("/home")
	public String saleHomeMethod() {
		return "saleHomePage"; // returns Homepage.jsp file
	}
	
	@RequestMapping("/add")
	public String saleAddMethod() {
		return "saleAddPage"; // returns Homepage.jsp file
	}
	
	@RequestMapping("/adddata")
	public ModelAndView saleAddMethod(Sale sale) {
		saleRepo.save(sale);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject(sale);
		modelAndView.setViewName("saleAddResponsePage");
		return modelAndView; 
	}
	
	@CrossOrigin(origins = "http://localhost:8081") // Enable local CORS
	@RequestMapping(path="/list")
	@ResponseBody
	public Iterable<Sale> saleListMethod() {
		return saleRepo.findAll();
	}
	
	@RequestMapping("/filter")
	public String saleFilterMethod() {
		return "saleFilterPage";	
	}
	
	@RequestMapping("/filterdata")
	@ResponseBody
	public Iterable<Sale> saleFilterDataMethod(String startdate, String enddate) throws ParseException{
		Date startdate2 = new Date();
		try {
			startdate2 = new SimpleDateFormat("yyyy-mm-dd").parse(startdate);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}  
		Date enddate2 = new Date();
		try {
			enddate2 = new SimpleDateFormat("yyyy-mm-dd").parse(enddate);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}  
		return saleRepo.findByDateOfSaleBetween(startdate2, enddate2);
	}
	
	@RequestMapping(path="/filterdata2", produces={"application/json"})
	@ResponseBody
	public List<Sale> saleFilterData2Method(Character ch) {
		return saleRepo.findBySellerFirstLetter(ch);
	}
	
	@GetMapping(path="/filterdata3", produces={"application/json"})
	@ResponseBody
	public List<SaleDto> saleFilterData3Method(Character ch) {
		return service.findBySellerFirstLetterService(ch).stream().map(sale -> modelMapper.map(sale, SaleDto.class)).collect(Collectors.toList());
	}
	
	@RequestMapping("/update")
	public String updateHomeMethod() {
		return "updateHomePage";
	}
	
	@RequestMapping("/updatedata")
	@ResponseBody
	public ResponseEntity<String> updateDataMethod(SaleDto saleDto) {
		if(saleDto.getSaleId()==null)
			return new ResponseEntity<>("Please ReCheck", HttpStatus.OK);
		Sale sale = saleRepo.findById(saleDto.getSaleId()).get();
		// Sale sale = saleRepo.findById(saleDto.getSaleId()).orElse(new Sale());
		if(saleDto.getBuyer()!="")
			sale.setBuyer(saleDto.getBuyer());
		if(saleDto.getSeller()!="")
			sale.setSeller(saleDto.getSeller());
		saleRepo.save(sale);
		return new ResponseEntity<>("Updated", HttpStatus.OK);
	}
	// measure
	@RequestMapping("/count-javaconfig")
	@ResponseBody
	public String countMethod() {
		return "The total count is " + saleRepo.count();
	}
	
	@RequestMapping(path = "/delete")
	@ResponseBody
	public String saleDeleteMethod(Integer saleId) {
		if (saleId!=null) {
			saleRepo.deleteById(saleId);
			return "Deleted";
		}	
		return "SaleId Absent";
	}
	
	@RequestMapping("/adddata2")
	public ModelAndView saleAdd2Method(@RequestBody Sale sale) {
		saleRepo.save(sale);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject(sale);
		modelAndView.setViewName("saleAddResponsePage");
		return modelAndView; 
	}
	
	
	@RequestMapping(path="/all", produces= {"application/xml"})
	@ResponseBody
	public Iterable<Sale> saleViewMethod() {
	    return saleRepo.findAll(); // return "[{"xyz": 123, "abc": "pqr"}, ...]";
    }

	@GetMapping(path="/sale/{saleId}")
	@ResponseBody
	public Optional<Sale> saleGetMethod(@PathVariable("saleId") Integer saleId) {
	    return saleRepo.findById(saleId);	
    }
	
	@DeleteMapping(path="/sale/{saleId}")
	@ResponseBody
	public String saleDeleteMethod_(@PathVariable("saleId") Integer saleId) {
		saleRepo.deleteById(saleId);
		return "Deleted";
    }
		
  // http://localhost:8081/update?saleId=202&buyer=SRK
  // https://www.baeldung.com/mapstruct#:~:text=Luckily%2C%20MapStruct%20has%20solid%20support,CDI%2C%20it%20would%20be%20cdi.
  // https://www.javaguides.net/2021/02/spring-boot-dto-example-entity-to-dto.html	
  // https://www.baeldung.com/hibernate-save-persist-update-merge-saveorupdate	
	@PutMapping(path="/put")
	public void updateCustomer(@RequestBody SaleDto saleDto) {
	    // Sale sale = saleRepo.findById(saleDto.getSaleId()).get();
	    service.updateEntityByDto(saleDto);
	    // Questions: Throws 404 error, Id not mapped, 
	    // save() vs merge() vs persist() vs saveorUpdate()
	}
	
	@RequestMapping("/test")
	void testmethod(@RequestBody Sale sale) {
		saleRepo.save(sale);
	}
	
	@RequestMapping("/john")
	@ResponseBody
	public String john() {
		return "john";
	}
	@RequestMapping("/mary")
	@ResponseBody
	public String mary() {
		return "mary";
	}
	@RequestMapping("/susan")
	@ResponseBody
	public String susan() {
		return "susan";
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public String register(@RequestBody Registration registration) {
		registration.setPass("{noop}" + registration.getPass());
		registerRepo.save(registration);
		return "Registered";
	}
	
	@RequestMapping("/roller")
	@ResponseBody
	public String roller(@RequestBody Authority authority) {
		authRepo.save(authority);
		return "Rolled";
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public String logoff(String logoutString) {
		return "Logged Out. Cookies Deleted";
	}
}
