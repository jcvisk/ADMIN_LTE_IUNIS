package com.iunis.adminiunis.service;

import com.iunis.adminiunis.domain.Carrera;
import com.iunis.adminiunis.dto.CarreraDto;
import com.iunis.adminiunis.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CarreraServiceImpl implements CarreraService{

    @Autowired
    CarreraRepository carreraRepository;

    @Override
    public List<Carrera> findNumInscritos() {
        return carreraRepository.findNumInscritos();
    }

}
