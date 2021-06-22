package com.iunis.adminiunis.service;

import com.iunis.adminiunis.domain.Alumno;
import com.iunis.adminiunis.domain.Usuario;

import java.util.List;

public interface AlumnoService {

    List<Alumno> listAlumnos();

    void createAlumno(Alumno alumno) throws Exception;
}
