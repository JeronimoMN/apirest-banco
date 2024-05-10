package com.api.apirestbanco.model;

public class CreateAccount {
    private String cedulaCliente;
    private String tipoCuenta;
    private Integer montoInicial;

    public String getCedulaCliente() {
        return cedulaCliente;
    }
    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }
    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Integer getMontoInicial() {
        return montoInicial;
    }

    public void setMontoInicial(Integer montoInicial) {
        this.montoInicial = montoInicial;
    }
}
