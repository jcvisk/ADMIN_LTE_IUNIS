package com.iunis.adminiunis.controller;

import com.iunis.adminiunis.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class GeneralController {

    @Autowired
    CarreraService carreraService;

    @GetMapping("/display")
    public String display(Model model){
        model.addAttribute("donutData", carreraService.findNumInscritos());
        //System.out.println(carreraService.findNumInscritos());

        return "dashboard";
    }
}
