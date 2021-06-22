package com.iunis.adminiunis.repository;

import com.iunis.adminiunis.domain.Estatus;
import com.iunis.adminiunis.domain.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Optional<Usuario> findUsuarioByUserNameAndEstatus(String nombre, Estatus estatus);

    List<Usuario> findUsuarioByEstatus(Estatus estatus);

    Usuario findUsuarioByUserName(String userName);



}
