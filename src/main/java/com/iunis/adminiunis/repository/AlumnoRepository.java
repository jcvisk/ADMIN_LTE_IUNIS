package com.iunis.adminiunis.repository;

import com.iunis.adminiunis.dao.InscritosDao;
import com.iunis.adminiunis.domain.Alumno;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlumnoRepository extends CrudRepository<Alumno, Long> {

    /*@Query(value = "select alumnos.idcarrera, carreras.descripcion, carreras.color from alumnos , carreras where alumnos.idcarrera = carreras.id",nativeQuery = true)
    List<Alumno> alumnoCarrera();*/

    /*@Query(value = "select alumnos.idcarrera, carreras.descripcion, carreras.color from alumnos , carreras where alumnos.idcarrera = carreras.id",nativeQuery = true)
    Integer countAllByIdCarrera(Long idCarrera);*/

    @Query(value = "SELECT COUNT(*) AS inscritos, carreras.descripcion AS carrera, carreras.color FROM alumnos, carreras WHERE alumnos.idcarrera = carreras.id GROUP BY alumnos.idcarrera, carreras.descripcion, carreras.color",nativeQuery = true)
    List<InscritosDao> findInscritosCarreraColor();


}
