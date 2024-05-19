package com.api.apirestbanco.model;

import java.sql.Date;

public class UserDateMoves {

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFin) {
        this.fechaFinal = fechaFin;
    }

    private String cuenta;
    private Date fechaInicio;
    private Date fechaFinal;
}
