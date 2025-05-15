package com.demo.democontroller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class DemoController {

    @RequestMapping
    public String test(Model model)
    {
        System.out.println("test");
        model.addAttribute("message", "Aditya Raut");
        model.addAttribute("username", "Adit");
        return "test";
    }

    @RequestMapping("/success")
    public String success()
    {
        System.out.println("success");
        return "success";
    }

}
