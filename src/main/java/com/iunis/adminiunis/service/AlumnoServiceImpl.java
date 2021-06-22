package com.iunis.adminiunis.service;

import com.iunis.adminiunis.DomayKeys;
import com.iunis.adminiunis.domain.Alumno;
import com.iunis.adminiunis.domain.Usuario;
import com.iunis.adminiunis.repository.AlumnoRepository;
import com.iunis.adminiunis.utilities.DateUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AlumnoServiceImpl implements AlumnoService{

    @Autowired
    AlumnoRepository alumnoRepository;

    @Override
    public List<Alumno> listAlumnos() {
        return (List<Alumno>) alumnoRepository.findAll();
    }

    @Override
    public void createAlumno(Alumno alumno) throws Exception {
        alumno.getDatosPersonales().setEdad(DateUtilities.calcEdadByFechaNac(alumno.getDatosPersonales().getFechaNacimiento()));
        alumno.setEstatus(DomayKeys.ESTATUS_GENERAL_ACTIVO);
        alumnoRepository.save(alumno);
    }
}
