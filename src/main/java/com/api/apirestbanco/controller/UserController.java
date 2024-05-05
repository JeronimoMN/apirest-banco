package com.api.apirestbanco.controller;

import com.api.apirestbanco.model.UserModel;
import com.api.apirestbanco.model.UserRequest;
import com.api.apirestbanco.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/validarUsuarioClave")
    public ResponseEntity<String> validarUsuarioClave(@RequestBody UserRequest request){
        String nombreUsuario= request.getNombreUsuario();
        String claveCuenta= request.getClaveCuenta();
        
        boolean esValido=  userService.validarUsuarioClave(nombreUsuario, claveCuenta);

        if (esValido){
            return ResponseEntity.ok("Valido");
        }else{
            return ResponseEntity.status(401).body("No es valido");
        }
       }
}
