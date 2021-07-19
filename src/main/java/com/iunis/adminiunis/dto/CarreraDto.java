package com.iunis.adminiunis.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CarreraDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String descripcion;
    private String color;
    private Long inscritos;

}
