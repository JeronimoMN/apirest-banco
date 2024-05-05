package com.api.apirestbanco.model;

public class UserRequest {
    private String nombreUsuario;
    private String claveCuenta;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClaveCuenta() {
        return claveCuenta;
    }

    public void setClaveCuenta(String claveCuenta) {
        this.claveCuenta = claveCuenta;
    }
}
