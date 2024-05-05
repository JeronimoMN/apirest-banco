package com.api.apirestbanco.service;

import com.api.apirestbanco.model.UserModel;
import com.api.apirestbanco.repositorie.IUserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
}
