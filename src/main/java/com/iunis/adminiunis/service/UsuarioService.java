package com.iunis.adminiunis.service;

import com.iunis.adminiunis.domain.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> listUsuarios();

    void createUsuario(Usuario usuario) throws Exception;

    void updateUsuario(Usuario usuario) throws Exception;

    void updateUsuarioTest(Usuario usuario) throws Exception;

    void deleteUsuario(Usuario usuario);

    void modifyPasswordUsuario(Long idUsuario, String password) throws Exception;

    Usuario findUsuarioById(Long idUsuario) throws Exception;

    List<Usuario> findUsuarioByEstatusActivo();

    Usuario findUsuarioByUsuarioEnSesion();
}
