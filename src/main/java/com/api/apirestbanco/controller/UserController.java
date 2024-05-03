package com.api.apirestbanco.controller;

import com.api.apirestbanco.model.UserModel;
import com.api.apirestbanco.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/login")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getusers")
    public ArrayList<UserModel> getUsers(){
        return this.userService.getUser();
    }
}
