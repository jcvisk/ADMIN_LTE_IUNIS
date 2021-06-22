package com.iunis.adminiunis.controller;

import com.iunis.adminiunis.domain.Usuario;
import com.iunis.adminiunis.repository.RoleRepository;
import com.iunis.adminiunis.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/perfil")
public class TestController {

    @Autowired
    UsuarioService usuarioService;

    /*@ModelAttribute("usuarioEnSession")
    public Usuario UsuarioEnSession(){
        return usuarioService.findUsuarioByUsuarioEnSesion();
    }*/

    @GetMapping("/display")
    public String perfilDisplay(Model model){
        model.addAttribute("userLogged", usuarioService.findUsuarioByUsuarioEnSesion());
        return "perfil";
    }

    @PostMapping("/update")
    public String perfilUpdate(Usuario usuario) throws Exception{
        usuarioService.updateUsuario(usuario);
        return "redirect:/logout";
    }
}
