package com.api.apirestbanco.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id_cliente;

    @Column
    private String nombres_cliente;
    @Column
    private String apellidos_cliente;
    @Column
    private String celular_cliente;
    @Column
    private String direccion_cliente;
    @Column
    private String nombre_usuario;
    @Column
    private String clave_dinamica;
    @Column

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombres_cliente() {
        return nombres_cliente;
    }

    public void setNombres_cliente(String nombres_cliente) {
        this.nombres_cliente = nombres_cliente;
    }

    public String getApellidos_cliente() {
        return apellidos_cliente;
    }

    public void setApellidos_cliente(String apellidos_cliente) {
        this.apellidos_cliente = apellidos_cliente;
    }

    public String getCelular_cliente() {
        return celular_cliente;
    }

    public void setCelular_cliente(String celular_cliente) {
        this.celular_cliente = celular_cliente;
    }

    public String getDireccion_cliente() {
        return direccion_cliente;
    }

    public void setDireccion_cliente(String direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getClave_dinamica() {
        return clave_dinamica;
    }

    public void setClave_dinamica(String clave_dinamica) {
        this.clave_dinamica = clave_dinamica;
    }
}
