package com.spring.um.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

	@GetMapping("/")
	public ModelAndView loginPage()
	{
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
}
