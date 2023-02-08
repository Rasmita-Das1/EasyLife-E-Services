package com.easylife.eservices.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/")
	public String homePage() {
		return "<h1>Easylife E-Services Rest APIs</h1>";
	}

}
