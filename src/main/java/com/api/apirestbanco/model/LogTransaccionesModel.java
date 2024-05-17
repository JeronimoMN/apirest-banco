package com.api.apirestbanco.model;
import jakarta.persistence.*;

@Entity
@Table(name = "log_transacciones")
public class LogTransaccionesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_transaccion;

    @Column
    private String nombre_usuario;
    @Column
    private String cedula;
    @Column
    private String numero_cuenta;
    @Column
    private String tipo_transaccion;
    @Column
    private String monto;
    @Column
    private String fecha;


    public Long getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(Long id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(String numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public String getTipo_transaccion() {
        return tipo_transaccion;
    }

    public void setTipo_transaccion(String tipo_transaccion) {
        this.tipo_transaccion = tipo_transaccion;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}