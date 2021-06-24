package com.iunis.adminiunis.controller;

import com.iunis.adminiunis.domain.Alumno;
import com.iunis.adminiunis.domain.Carrera;
import com.iunis.adminiunis.repository.AlumnoRepository;
import com.iunis.adminiunis.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class GeneralController {

    @Autowired
    AlumnoRepository alumnoRepository;

    @GetMapping("/display")
    public String display(Model model){

        /*model.addAttribute("numTic", alumnoRepository.countUsuariosCarreras(1L));
        model.addAttribute("numEnf", alumnoRepository.countUsuariosCarreras(2L));
        model.addAttribute("numNut", alumnoRepository.countUsuariosCarreras(3L));
        model.addAttribute("numPsi", alumnoRepository.countUsuariosCarreras(4L));
        model.addAttribute("numCon", alumnoRepository.countUsuariosCarreras(5L));
        model.addAttribute("numEdu", alumnoRepository.countUsuariosCarreras(6L));*/

        model.addAttribute("donutData", alumnoRepository.findInscritosCarreraColor());

        return "dashboard";
    }

    @GetMapping("/usuarios")
    public String usuarios(){
        return "usuario";
    }
}
