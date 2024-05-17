package com.api.apirestbanco.model;
import jakarta.persistence.*;
@Entity
@Table(name = "log_accesos")
public class LogAccessModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_acceso;

    @Column
    private String nombre_usuario;
    @Column
    private String cedula_titular;
    @Column
    private String tipo_acceso;
    @Column
    private String fecha_acceso;
    @Column
    private String tipo_usuario;

    public Long getId_acceso() {
        return id_acceso;
    }

    public void setId_acceso(Long id_acceso) {
        this.id_acceso = id_acceso;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getCedula_titular() {
        return cedula_titular;
    }

    public void setCedula_titular(String cedula_titular) {
        this.cedula_titular = cedula_titular;
    }

    public String getTipo_acceso() {
        return tipo_acceso;
    }

    public void setTipo_acceso(String tipo_acceso) {
        this.tipo_acceso = tipo_acceso;
    }

    public String getFecha_acceso() {
        return fecha_acceso;
    }

    public void setFecha_acceso(String fecha_acceso) {
        this.fecha_acceso = fecha_acceso;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }
}
