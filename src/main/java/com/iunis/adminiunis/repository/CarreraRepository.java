package com.iunis.adminiunis.repository;

import com.iunis.adminiunis.domain.Carrera;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraRepository extends CrudRepository<Carrera, Long> {
}
