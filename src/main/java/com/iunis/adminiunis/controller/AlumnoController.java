package com.iunis.adminiunis.controller;

import com.iunis.adminiunis.domain.Alumno;
import com.iunis.adminiunis.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    AlumnoService alumnoService;

    @GetMapping("/display")
    public String display(Model model){
        //Sirven para activar los plugins
        model.addAttribute("dataTables", true);
        model.addAttribute("select2", true);

        model.addAttribute("alumnos", alumnoService.listAlumnos());
        return "alumno";
    }

    @GetMapping("/form")
    public String perfilDisplay(Model model, Alumno alumno){

        return "alumnoCreate";
    }
}
