package com.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.spring.mvc.model.Student;
import com.spring.mvc.service.StudentService;

@Controller
public class HomeController {
	
	@Autowired
	StudentService studentService;
	String name = "Aditya Raut";
	@ModelAttribute
	public void common(Model model) {
		System.out.println(" inside ModelAttribute annotation");
		model.addAttribute("username", name);
	}

	@RequestMapping("/")
	public String home1() {
		return "homepage";
	}

	@RequestMapping("/home")
	public String home(Model model) {

		Student student = new Student(1, "Virat", 78.5);
		model.addAttribute("student", student);
		return "home";
	}

	@RequestMapping("/newhome")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		Student student = new Student(22, "Ben", 98.6);
		modelAndView.addObject("student", student);
		modelAndView.setViewName("home");
		return modelAndView;
	}

	@RequestMapping("/addstudent")
	public String addStudent() {
		return "addstudent";
	}
	
	@RequestMapping("/list-students")
	public String listStudents(Model model) {
		model.addAttribute("students",studentService.listStudents());
		return "list-students";
	}

	@PostMapping(path = "/saveStudentDetails")
	public String saveStudent(@ModelAttribute Student student, Model model) {
		model.addAttribute("student", student);
		return "home";
	}
	
	@RequestMapping("/search")
	public String search()
	{
		return "search";
	}
	
	@GetMapping("/querygoogle")
	public RedirectView querygoogle(@RequestParam("search")String search)
	{
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl("https://www.google.com/search?q="+search);
		return redirectView;
	}
	
	
	
}
