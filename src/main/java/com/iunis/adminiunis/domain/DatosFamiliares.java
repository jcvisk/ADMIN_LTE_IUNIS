package com.iunis.adminiunis.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "datosfamiliares")
public class DatosFamiliares implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "nombrepadre")
    private String nombrePadre;

    @Column(name = "apellidopadre")
    private String apellidoPadre;

    @Column(name = "direccionpadre")
    private String direccionPadre;

    @Column(name = "celularpadre")
    private String celularpadre;

    @Column(name = "ocupacionpadre")
    private String ocupacionPadre;

    /*---------------------------*/

    @Column(name = "nombremadre")
    private String nombreMadre;

    @Column(name = "apellidomadre")
    private String apellidoMadre;

    @Column(name = "direccionmadre")
    private String direccionMadre;

    @Column(name = "celularmadre")
    private String celularMadre;

    @Column(name = "ocupacionmadre")
    private String ocupacionMadre;

    @Column(name = "estadocivil")
    private String estadoCivil;

}
