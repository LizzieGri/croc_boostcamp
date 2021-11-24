package com.elections.croc.elections_mysql.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForAllEmployees {
    @RequestMapping("/")
    public String goIndex(Model model) {
        return "index";
    }

    @GetMapping()
    public String homePage(){
        return "redirect:/login";
    }
}
