package com.springboot.annotations;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {

    @RequestMapping(value = "/home/{userid}")
    public String home(@PathVariable("userid") int id, @RequestParam("test") String test)
    {
        return "Hello World "+id+" "+test;
    }

    @GetMapping("/")
    public ModelAndView test()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        return modelAndView;
    }

    @GetMapping("/success")
    public ModelAndView success()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        return modelAndView;
    }
}
