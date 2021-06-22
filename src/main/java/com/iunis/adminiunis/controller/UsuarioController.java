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
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RoleRepository roleRepository;

    /**
     * Pagina inicial de usuarios
     * @param model
     * @param usuario
     * @return
     */
    @GetMapping("/display")
    public String usuarios(Model model, Usuario usuario){
        //Sirven para activar los plugins
        model.addAttribute("dataTables", true);
        model.addAttribute("select2", true);

        //lista deusuarios y de roles
        model.addAttribute("usuarios", usuarioService.findUsuarioByEstatusActivo());
        model.addAttribute("roles", roleRepository.findAll());


        return "usuario";
    }

    /**
     * path para guardar al nuevo usuaio
     * @param usuario
     * @return
     */
    @PostMapping("/usuarioCreate")
    public String createUsuario(Usuario usuario, Model model){
        try{
            usuarioService.createUsuario(usuario);
        }catch (Exception e){
            //Sirven para activar los plugins
            model.addAttribute("dataTables", true);
            model.addAttribute("select2", true);

            //lista deusuarios y de roles
            model.addAttribute("usuarios", usuarioService.findUsuarioByEstatusActivo());
            model.addAttribute("roles", roleRepository.findAll());

            //mandano el mensaje de error
            model.addAttribute("errorMesaage", e.getMessage());

            return "usuario";
        }
        return "redirect:/usuarios/display";
    }

    /**
     * carga los datos del objeto y abre el modal de edicion
     * @param model
     * @param usuario
     * @return
     * @throws Exception
     */
    @GetMapping("/loadUpdate")
    public String loadUpdate(Model model, Usuario usuario) throws Exception{
        //Sirven para activar los plugins
        model.addAttribute("dataTables", true);
        model.addAttribute("select2", true);

        //Sirven para activar el modo edicion en el formulario y no mostrar el camo de contraseña
        model.addAttribute("editMode", true);

        //lista deusuarios y de roles
        model.addAttribute("usuarios", usuarioService.findUsuarioByEstatusActivo());
        model.addAttribute("roles", roleRepository.findAll());

        //mandando el objeto lleno
        model.addAttribute("usuario", usuarioService.findUsuarioById(usuario.getId()));

        return "usuario";
    }

    /**
     * recibe el objeto con los campos actualizados y los guarda
     * @param usuario
     * @return
     * @throws Exception
     */
    @PostMapping("/usuarioUpdate")
    public String usuarioUpdate(Usuario usuario) throws Exception{
        usuarioService.updateUsuario(usuario);
        return "redirect:/usuarios/display";
    }

    /**
     * recibe el objeto obtiene el id lo busco y si lo encuentra le cambia el estatus a 2
     * @param usuario
     * @return
     * @throws Exception
     */
    @GetMapping("/usuarioDelete")
    public String delete(Usuario usuario) throws Exception{
        usuario = usuarioService.findUsuarioById(usuario.getId());
        usuarioService.deleteUsuario(usuario);
        return "redirect:/usuarios/display";
    }

    /**
     * carga los datos del objeto (solo contraseña) y abre el modal
     * @param model
     * @param usuario
     * @return
     * @throws Exception
     */
    @GetMapping("/modalPassword")
    public String modalPassword(Model model, Usuario usuario) throws  Exception{
        //Sirven para activar los plugins
        model.addAttribute("dataTables", true);
        model.addAttribute("select2", true);

        //lista deusuarios y de roles
        model.addAttribute("usuarios", usuarioService.findUsuarioByEstatusActivo());
        model.addAttribute("roles", roleRepository.findAll());

        //mandando el objeto lleno
        model.addAttribute("usuario", usuarioService.findUsuarioById(usuario.getId()));

        return "usuario";
    }

    /**
     * recibe el objeto con la nueva contraseña, y guarda el objeto
     * @param usuario
     * @return
     * @throws Exception
     */
    @PostMapping("/passwordUpdate")
    public String passwordUpdate(Usuario usuario) throws Exception {
        usuarioService.modifyPasswordUsuario(usuario.getId(), usuario.getUserPassword());
        return "redirect:/usuarios/display";
    }
}
