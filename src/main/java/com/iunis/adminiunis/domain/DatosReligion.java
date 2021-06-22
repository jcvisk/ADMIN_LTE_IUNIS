package com.iunis.adminiunis.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "datosreligion")
public class DatosReligion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "religion")
    private String religion;

    @Column(name = "bautizado")
    private Boolean bautizado;

    @Column(name = "distrito")
    private String distrito;

    @Column(name = "asociacion")
    private String asociacion;

}
