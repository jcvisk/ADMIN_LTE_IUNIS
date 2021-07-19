package com.iunis.adminiunis.repository;

import com.iunis.adminiunis.domain.Alumno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Long> {

}
