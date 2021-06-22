package com.iunis.adminiunis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class GeneralController {

    @GetMapping("/display")
    public String display(){
        return "dashboard";
    }

    @GetMapping("/usuarios")
    public String usuarios(){
        return "usuario";
    }
}
