package com.example.demo1;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// api=http://localhost:8080/student?name=Prashant&subject=Maths
@Controller
public class StudentController {
	private final AtomicLong counter = new AtomicLong();
	@RequestMapping("/student")
	@ResponseBody
	public Student studentMethod(@RequestParam(value = "name", defaultValue = "NA") String nameV, @RequestParam(value = "subject", defaultValue = "NA") String subjectV) {	
		System.out.println(nameV + subjectV);
		return new Student(counter.incrementAndGet(), nameV, subjectV);
	}
}
