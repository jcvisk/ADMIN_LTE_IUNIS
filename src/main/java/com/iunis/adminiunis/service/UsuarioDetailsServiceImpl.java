package com.iunis.adminiunis.service;

import com.iunis.adminiunis.DomayKeys;
import com.iunis.adminiunis.domain.Role;
import com.iunis.adminiunis.domain.Usuario;
import com.iunis.adminiunis.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class UsuarioDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario appUser = usuarioRepository.findUsuarioByUserNameAndEstatus(username, DomayKeys.ESTATUS_GENERAL_ACTIVO).orElseThrow(() -> new UsernameNotFoundException("Usuario no válido"));

        Set grantList = new HashSet();
        for(Role role : appUser.getRoles()){
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getDescripcion());
            grantList.add(grantedAuthority);
        }

        UserDetails userDetails = (UserDetails) new User(
                username,
                appUser.getUserPassword(),
                grantList);

        return userDetails;
    }

}
