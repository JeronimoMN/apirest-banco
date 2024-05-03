package com.api.apirestbanco.service;

import com.api.apirestbanco.model.UserModel;
import com.api.apirestbanco.repositorie.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;

    public ArrayList<UserModel> getUser(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }
}
