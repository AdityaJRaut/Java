package com.itp.FirstSpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

	@GetMapping("/welcome")
	public String welcome()
	{
		return "home";
	}
}
