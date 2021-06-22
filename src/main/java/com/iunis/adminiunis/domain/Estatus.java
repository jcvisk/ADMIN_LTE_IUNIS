package com.iunis.adminiunis.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "estatus")
public class Estatus implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    public Estatus(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Estatus() {
    }
}

