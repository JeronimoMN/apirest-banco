package com.api.apirestbanco.model;

import java.sql.Date;

public class UserMoves {
    private Double monto;
    private Date fecha;

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
