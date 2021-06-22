package com.iunis.adminiunis.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "datospersonales")
public class DatosPersonales implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidopaterno")
    private String apellidoPaterno;

    @Column(name = "apellidomaterno")
    private String apellidoMaterno;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fechanacimiento")
    private Date fechaNacimiento;

    @Column(name = "edad")
    private String edad;

    /*Convertir en objeto*/
    @Column(name = "estadocivil")
    private String estadoCivil;

    @Column(name = "lugarnacimiento")
    private String lugarNacimiento;

    @Column(name = "nacionalidad")
    private String nacionalidad;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "trabajo")
    private String trabajo;

    /*Convertir en objeto*/
    @Column(name = "beca")
    private String beca;




    /*DATOS DE PRUEBA*/
    @Column(name = "educacion")
    private String educacion;

    @Column(name = "habilidad")
    private String habilidad;

    @Column(name = "nota")
    private String nota;

    @Column(name = "cargo")
    private String cargo;

}
