package com.api.apirestbanco.service;

import com.api.apirestbanco.model.*;
import com.api.apirestbanco.repositorie.IUserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    public ArrayList<UserModel> getUser(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    @PersistenceContext
    private EntityManager entityManager;

    public boolean validarUsuarioClave(String nombreUsuario, String claveCuenta){
        Query query = entityManager.createNativeQuery("SELECT validar_usuario_clave(:nombreUsuario, :claveCuenta)", Boolean.class);
        query.setParameter("nombreUsuario", nombreUsuario);
        query.setParameter("claveCuenta", claveCuenta);
        return (Boolean) query.getSingleResult();
    }


    public String validarTrabajadorClave(String nombreUsuario, String claveCuenta){
        Query query = entityManager.createNativeQuery("SELECT validar_trabajador_clave(:nombreUsuario, :claveCuenta)", String.class);
        query.setParameter("nombreUsuario", nombreUsuario);
        query.setParameter("claveCuenta", claveCuenta);
        return (String) query.getSingleResult();
    }

    public List<UserAccount> getUserAccounts(String nombreUsuario){
        Query query = entityManager.createNativeQuery("SELECT * FROM obtener_cuentas_saldo(:nombreUsuario)");
        query.setParameter("nombreUsuario", nombreUsuario);
        List<UserAccount> result=  query.getResultList();
        return result;
    }

    public List<UserTypeAccount> getUserTypeAccounts(String nombreUsuario){
        Query query = entityManager.createNativeQuery("SELECT * FROM obtener_cuentas_tipo(:nombreUsuario)");
        query.setParameter("nombreUsuario", nombreUsuario);
        List<UserTypeAccount> result=  query.getResultList();
        return result;
    }


    public boolean transferirMontoUsuario(String cuenta, String cuentaDestino, Double monto){
        Query query = entityManager.createNativeQuery("SELECT transferir_monto(:cuenta, :cuentaDestino, :monto)", Boolean.class);
        query.setParameter("cuenta", cuenta);
        query.setParameter("cuentaDestino", cuentaDestino);
        query.setParameter("monto", monto);
        return (Boolean) query.getSingleResult();
    }

    public boolean crearCliente (String cedulaCliente, String nombreCliente, String apellidoCliente, String celularCliente, String direccionCliente, String nombreUsuario, String claveCuenta) {
        Query query = entityManager.createNativeQuery("SELECT ingresar_cliente(:cedulaCliente, :nombreCliente, :apellidoCliente, :celularCliente, :direccionCliente, :nombreUsuario, :claveCuenta )", Boolean.class);
        query.setParameter("cedulaCliente", cedulaCliente);
        query.setParameter("nombreCliente", nombreCliente);
        query.setParameter("apellidoCliente", apellidoCliente);
        query.setParameter("celularCliente", celularCliente);
        query.setParameter("direccionCliente", direccionCliente);
        query.setParameter("nombreUsuario", nombreUsuario);
        query.setParameter("claveCuenta", claveCuenta);

        return (Boolean) query.getSingleResult();
    }

    public boolean crearCuenta (String tipoCuenta, Integer montoInicial, String cedulaCliente) {
        Query query = entityManager.createNativeQuery("SELECT generar_cuenta(:tipoCuenta ,:montoInicial ,:cedulaCliente)", Boolean.class);
        query.setParameter("cedulaCliente", cedulaCliente);
        query.setParameter("tipoCuenta", tipoCuenta);
        query.setParameter("montoInicial", montoInicial);
        return (Boolean) query.getSingleResult();
    }

    public ArrayList<UsuarioModel> getUsersBank(){
        Query query = entityManager.createNativeQuery("SELECT * FROM obtener_usuarios()");
        ArrayList<UsuarioModel> result= (ArrayList<UsuarioModel>) query.getResultList();
        return result;
    }

    public String getDinamicPass(String nombreUsuario){
        Query query = entityManager.createNativeQuery("SELECT obtener_clave_dinamica(:nombreUsuario)");
        query.setParameter("nombreUsuario", nombreUsuario);
        return (String) query.getSingleResult();
    }
}
