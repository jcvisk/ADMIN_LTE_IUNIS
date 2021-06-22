package com.iunis.adminiunis.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "datosfinancieros")
public class DatosFinancieros implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @JoinColumn(name = "iddatospersonales", referencedColumnName = "id")
    @OneToOne(cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
    private DatosPersonales datospersonales;

    @JoinColumn(name = "iddatosubicacion", referencedColumnName = "id")
    @OneToOne(cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
    private DatosUbicacion datosUbicacion;

}
