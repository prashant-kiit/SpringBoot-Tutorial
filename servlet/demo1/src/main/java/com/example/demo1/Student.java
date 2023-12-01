package com.example.demo1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
// Domain Class used by RestInterface for Modeling
@JsonIgnoreProperties(ignoreUnknown = true)
public record Student(long roll, String name, String subject) {

	public Student(long roll, String name, String subject) {
		this.name = name;
		this.roll = roll;
		this.subject = subject;
	}
}