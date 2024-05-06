package com.api.apirestbanco.model;

public class UserTransferencia {
    private String cuenta;
    private String cuentaDestino;
    private Double monto;

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(String cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public Double getMonto() {
        return monto;
    }

    public Double setMonto(Double monto) {
        return this.monto = monto;
    }
}
