package com.iunis.adminiunis.service;


import com.iunis.adminiunis.domain.Carrera;
import com.iunis.adminiunis.dto.CarreraDto;

import java.util.List;

public interface CarreraService {

    List<Carrera> findNumInscritos();

}
