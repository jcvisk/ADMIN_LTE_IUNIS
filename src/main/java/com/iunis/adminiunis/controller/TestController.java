package com.iunis.adminiunis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class TestController {

    @GetMapping("/display")
    public String display(){
        return "template/template";
    }
}
