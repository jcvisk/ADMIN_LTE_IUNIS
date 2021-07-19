package com.iunis.adminiunis.repository;

import com.iunis.adminiunis.domain.Carrera;
import com.iunis.adminiunis.dto.CarreraDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Long> {

    @Query(value = "SELECT c.id, c.descripcion, c.color, COUNT(*) AS inscritos " +
            "FROM alumnos, carreras c " +
            "WHERE alumnos.idcarrera = c.id " +
            "GROUP BY c.id, c.descripcion, c.color, alumnos.idcarrera; ", nativeQuery = true)
    List<Carrera> findNumInscritos();


}
