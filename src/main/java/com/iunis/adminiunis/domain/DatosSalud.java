package com.iunis.adminiunis.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "datossalud")
public class DatosSalud implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "tiposangre")
    private String tipoSangre;

    @Column(name = "inpedimentofisico")
    private String inpedimentoFisico;

    @Column(name = "enfermedad")
    private String enfermedad;

    @Column(name = "alergia")
    private String alergia;

    @Column(name = "seguro")
    private String seguro;

}
