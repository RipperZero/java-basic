package com.zero.controller;

import java.util.Map;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class TestController {
	
	@RequestMapping(value = "/zero")
	public String executeOperation() {
		System.err.println("Success");
//		System.err.println(body.getClass());
		return "Success";
	}
}
