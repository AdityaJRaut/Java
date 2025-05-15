package com.annotate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ProductController {

	@GetMapping("/products")
	public String getProducts(@RequestBody String name)
	{
		return "index";
	}
}
