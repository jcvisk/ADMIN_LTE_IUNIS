package com.iunis.adminiunis.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "alumnos")
public class Alumno implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    /*@JoinColumn(name = "iddatosacademicos", referencedColumnName = "id")
    @OneToOne(cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
    private DatosAcademicos datosAcademicos;

    @JoinColumn(name = "iddatosfamiliares", referencedColumnName = "id")
    @OneToOne(cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
    private DatosFamiliares datosFamiliares;

    @JoinColumn(name = "iddatosfinancieros", referencedColumnName = "id")
    @OneToOne(cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
    private DatosFinancieros datosFinancieros;*/

    @JoinColumn(name = "iddatospersonales", referencedColumnName = "id")
    @OneToOne(cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
    private DatosPersonales datosPersonales;

    /*@JoinColumn(name = "iddatosreligion", referencedColumnName = "id")
    @OneToOne(cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
    private DatosReligion datosReligion;

    @JoinColumn(name = "iddatossalud", referencedColumnName = "id")
    @OneToOne(cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
    private DatosSalud datosSalud;

    @JoinColumn(name = "iddatosubicacion", referencedColumnName = "id")
    @OneToOne(cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
    private DatosUbicacion datosUbicacion;*/

    @ManyToOne
    @JoinColumn(name = "idcarrera", referencedColumnName = "id")
    private Carrera carrera;

    @ManyToOne
    @JoinColumn(name = "idestatus", referencedColumnName = "id")
    private Estatus estatus;
}
