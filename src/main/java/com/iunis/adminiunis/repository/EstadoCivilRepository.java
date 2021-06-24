package com.iunis.adminiunis.repository;

import com.iunis.adminiunis.domain.EstadoCivil;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoCivilRepository extends CrudRepository<EstadoCivil, Long> {
}
