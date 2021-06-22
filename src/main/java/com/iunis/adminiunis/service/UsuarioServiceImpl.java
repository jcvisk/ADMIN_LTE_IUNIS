package com.iunis.adminiunis.service;

import com.iunis.adminiunis.DomayKeys;
import com.iunis.adminiunis.utilities.DateUtilities;
import com.iunis.adminiunis.domain.Usuario;
import com.iunis.adminiunis.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<Usuario> listUsuarios() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    /**
     * Guarda al usuario
     * @param usuario
     * @throws Exception error al guardar el usuario
     */
    @Override
    public void createUsuario(Usuario usuario) throws Exception {
        //validando que el usuario este disponible
        if (checkUserNameAvailable(usuario)){
            //encriptando password
            usuario.setUserPassword(bCryptPasswordEncoder.encode(usuario.getUserPassword()));
            //calculando edad y guardandola
            usuario.getDatospersonales().setEdad(DateUtilities.calcEdadByFechaNac(usuario.getDatospersonales().getFechaNacimiento()));
            //insertando estatus activo
            usuario.setEstatus(DomayKeys.ESTATUS_GENERAL_ACTIVO);
            //guardando usuario
            usuarioRepository.save(usuario);
        }
    }

    /**
     * Buca al usuario y actualiza sus datos excepto el password
     * @param fromUser
     * @throws Exception
     */
    @Override
    public void updateUsuario(Usuario fromUser) throws Exception {
        Usuario toUser = findUsuarioById(fromUser.getId());
        mapUsuario(fromUser, toUser);
        usuarioRepository.save(toUser);
    }

    @Override
    public void updateUsuarioTest(Usuario usuario) throws Exception {

        Usuario usuarioEncontrado = findUsuarioById(usuario.getId());

        usuarioRepository.save(usuarioEncontrado);
    }

    /**
     * Busca al usuario y le cambia a estatus Inactivo
     * @param usuario
     */
    @Override
    public void deleteUsuario(Usuario usuario) {
        usuario.setEstatus(DomayKeys.ESTATUS_GENERAL_INACTIVO);
        usuarioRepository.save(usuario);
    }

    /**
     * Busca al usuario y actualiza el password
     * @param idUsuario
     * @param password
     * @throws Exception
     */
    @Override
    public void modifyPasswordUsuario(Long idUsuario, String password) throws Exception {
        Usuario usuario = findUsuarioById(idUsuario);
        usuario.setUserPassword(bCryptPasswordEncoder.encode(password));
        usuarioRepository.save(usuario);
    }

    /**
     * busca a un usuario con id
     * @param idUsuario
     * @return el usuario encontrado
     * @throws Exception El usuario no existe.
     */
    @Override
    public Usuario findUsuarioById(Long idUsuario) throws Exception {
        return usuarioRepository.findById(idUsuario).orElseThrow(() -> new Exception("El usuario con el id "+idUsuario+" no existe."));
    }

    /**
     * Busca a los usuario que tienen estatus activo
     * @return lista de usuarios
     */
    @Override
    public List<Usuario> findUsuarioByEstatusActivo() {
        return usuarioRepository.findUsuarioByEstatus(DomayKeys.ESTATUS_GENERAL_ACTIVO);
    }

    /**
     * Busca los datos del usuario en sesion
     * @return
     */
    @Override
    public Usuario findUsuarioByUsuarioEnSesion() {
        return usuarioRepository.findUsuarioByUserName(nameOfUserInSession());
    }

    /**
     * Busca si el usuario ingresado exite en la base de datos
     * @param usuario
     * @return true or false
     * @throws Exception Usuario no disponible
     */
    private boolean checkUserNameAvailable(Usuario usuario) throws Exception {
        Usuario usuarioEncontrado = usuarioRepository.findUsuarioByUserName(usuario.getUserName());
        if (usuarioEncontrado != null){
            throw new Exception("Usuario no disponible");
        }
        return true;
    }

    /*private boolean checkPasswordValid(Usuario usuario) throws Exception {
        if ( !usuario.getUserPassword().equals(usuario.getConfirmUserPassword())){
            throw new Exception("Las contraseñas no coinciden");
        }
        return true;
    }*/

    /**
     * Busca al usuario en sesion
     * @return el userName del usuario en sesion
     */
    private String nameOfUserInSession() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        return userDetails.getUsername();
    }

    /**
     * Para actualizar el ususaior sin actualizar la contraseña
     * @param from donde vine el objeto lleno
     * @param to el objeto que se llena
     */
    protected void mapUsuario(Usuario from, Usuario to){

        if (from.getUserName() != null && !from.getUserName().equals("")){
            to.setUserName(from.getUserName());
        }
        if (from.getUserPassword() != null && !from.getUserPassword().equals("")){
            to.setUserPassword(bCryptPasswordEncoder.encode(from.getUserPassword()));
        }
        if (from.getRoles() != null){
            to.setRoles(from.getRoles());
        }
        if(from.getEstatus() != null){
            to.setEstatus(from.getEstatus());
        }
        if (from.getDatospersonales().getNombre() != null && !from.getDatospersonales().getNombre().equals("")){
            to.getDatospersonales().setNombre(from.getDatospersonales().getNombre());
        }
        if (from.getDatospersonales().getApellidoPaterno() != null && !from.getDatospersonales().getApellidoPaterno().equals("")){
            to.getDatospersonales().setApellidoPaterno(from.getDatospersonales().getApellidoPaterno());
        }
        if (from.getDatospersonales().getApellidoMaterno() != null && !from.getDatospersonales().getApellidoMaterno().equals("")){
            to.getDatospersonales().setApellidoMaterno(from.getDatospersonales().getApellidoMaterno());
        }
        if (from.getDatospersonales().getFechaNacimiento() != null && !from.getDatospersonales().getFechaNacimiento().equals("")){
            to.getDatospersonales().setFechaNacimiento(from.getDatospersonales().getFechaNacimiento());
            to.getDatospersonales().setEdad(DateUtilities.calcEdadByFechaNac(from.getDatospersonales().getFechaNacimiento()));
        }
        if (from.getDatospersonales().getCargo() != null && !from.getDatospersonales().getCargo().equals("")){
            to.getDatospersonales().setCargo(from.getDatospersonales().getCargo());
        }
        if (from.getDatospersonales().getEducacion() != null && !from.getDatospersonales().getEducacion().equals("")){
            to.getDatospersonales().setEducacion(from.getDatospersonales().getEducacion());
        }
        if (from.getDatospersonales().getHabilidad() != null && !from.getDatospersonales().getHabilidad().equals("")){
            to.getDatospersonales().setHabilidad(from.getDatospersonales().getHabilidad());
        }
        if (from.getDatospersonales().getNota() != null && !from.getDatospersonales().getNota().equals("")){
            to.getDatospersonales().setNota(from.getDatospersonales().getNota());
        }
    }
}
