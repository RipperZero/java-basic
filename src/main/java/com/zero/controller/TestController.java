package com.zero.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {
	
	@RequestMapping(value = "zero")
	public String executeOperation() {
		System.err.println("Success");
		return "Success";
	}
}
