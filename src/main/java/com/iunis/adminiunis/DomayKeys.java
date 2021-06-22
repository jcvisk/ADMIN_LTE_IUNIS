package com.iunis.adminiunis;

import com.iunis.adminiunis.domain.Estatus;

import java.io.Serializable;

public class DomayKeys implements Serializable {

    private DomayKeys(){}

    public static final Estatus ESTATUS_GENERAL_ACTIVO = new Estatus(1L, "ACTIVO");
    public static final Estatus ESTATUS_GENERAL_INACTIVO = new Estatus(2L, "INACTIVO");
    public static final Estatus ESTATUS_GENERAL_INSCRITO = new Estatus(3L, "INSCRITO");
    public static final Estatus ESTATUS_GENERAL_BAJA = new Estatus(4L, "BAJA");
    public static final Estatus ESTATUS_GENERAL_GRADUADO = new Estatus(5L, "GRADUADO");
    public static final Estatus ESTATUS_GENERAL_RECHAZADO = new Estatus(6L, "RECHAZADO");
}
