package com.api.apirestbanco.controller;

import com.api.apirestbanco.model.*;
import com.api.apirestbanco.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @PostMapping("/useraccount")
    public List<UserAccount> validarUsuarioCuenta(@RequestBody UserName request){
        String nombreUsuario= request.getNombreUsuario();
        List<UserAccount> account= userService.getUserAccounts(nombreUsuario);
        return account;
    }

    @PostMapping("/useraccountype")
    public List<UserTypeAccount> validarUsuarioTipoCuenta(@RequestBody UserName request){
        String nombreUsuario= request.getNombreUsuario();
        List<UserTypeAccount> account= userService.getUserTypeAccounts(nombreUsuario);
        return account;
    }

    @PostMapping("/transferirmonto")
    public ResponseEntity<String> transferirMonto(@RequestBody UserTransferencia request){
        String cuenta= request.getCuenta();
        String cuentaDestino= request.getCuentaDestino();
        Double monto = request.getMonto();

        boolean esValido=  userService.transferirMontoUsuario(cuenta, cuentaDestino, monto);

        if (esValido){
            return ResponseEntity.ok("Valido");
        }else{
            return ResponseEntity.status(401).body("No es valido");
        }
    }
}
