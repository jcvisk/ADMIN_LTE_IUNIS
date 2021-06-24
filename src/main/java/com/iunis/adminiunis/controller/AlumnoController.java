package com.iunis.adminiunis.controller;

import com.iunis.adminiunis.domain.Alumno;
import com.iunis.adminiunis.repository.CarreraRepository;
import com.iunis.adminiunis.repository.EstadoCivilRepository;
import com.iunis.adminiunis.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    AlumnoService alumnoService;

    @Autowired
    CarreraRepository carreraRepository;

    @Autowired
    EstadoCivilRepository estadoCivilRepository;

    @GetMapping("/display")
    public String display(Model model){
        //Sirven para activar los plugins
        model.addAttribute("dataTables", true);
        model.addAttribute("select2", true);

        model.addAttribute("alumnos", alumnoService.listAlumnos());

        return "alumno/alumno";
    }

    @GetMapping("/form")
    public String perfilDisplay(Model model, Alumno alumno){

        model.addAttribute("carreras", carreraRepository.findAll());
        model.addAttribute("estados", estadoCivilRepository.findAll());

        return "alumno/alumnoCreate";
    }

    @PostMapping("/create")
    public String create(Alumno alumno) throws Exception{
        alumnoService.createAlumno(alumno);
        return "redirect:/alumnos/display";
    }
}
