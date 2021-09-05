package com.uxpsystems.assignement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@GetMapping("/users")
	public String getUser()
	{
		return " Welcome User";
	}

}
