package com.api.apirestbanco.controller;

import com.api.apirestbanco.model.*;
import com.api.apirestbanco.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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


    @PostMapping("/validarTrabajadorClave")
    public ResponseEntity<String> validarTrabajoClave(@RequestBody UserRequest request){
        String nombreUsuario= request.getNombreUsuario();
        String claveCuenta= request.getClaveCuenta();

        String esValido= userService.validarTrabajadorClave(nombreUsuario, claveCuenta);

        if (esValido.equals("cajero")){
            return ResponseEntity.ok("cajero");
        }else if(esValido.equals("administrador")){
            return ResponseEntity.ok("administrador");
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

    @PostMapping("/crearcliente")
    public ResponseEntity<String> crearCliente(@RequestBody CreateClient request){
        String cedulaClientes= request.getCedulaCliente();
        String nombresCliente= request.getNombresCliente();
        String apellidosCliente = request.getApellidosCliente();
        String celularCliente = request.getCelularCliente();
        String direccionCliente = request.getDireccionCliente();
        String nombreUsuario= request.getNombreUsuario();
        String claveCliente = request.getClaveCliente();

        boolean esValido = userService.crearCliente(cedulaClientes,nombresCliente, apellidosCliente, celularCliente, direccionCliente, nombreUsuario, claveCliente);

        if(esValido){
            return ResponseEntity.ok("Agregado");
        }
        else{
            return ResponseEntity.status(401).body("No ha sido agregado");
        }
    }

    @PostMapping("/crearcuenta")
    public ResponseEntity<String> crearCuenta(@RequestBody CreateAccount request){
        String cedulaCliente= request.getCedulaCliente();
        String tipoCuenta = request.getTipoCuenta();
        Integer montoInicial = request.getMontoInicial();

        boolean esValido = userService.crearCuenta(tipoCuenta, montoInicial, cedulaCliente);

        if(esValido){
            return ResponseEntity.ok("Agregado");
        }
        else{
            return ResponseEntity.status(401).body("No ha sido agregado");
        }
    }


    @GetMapping("/getuserbanck")
    public ArrayList<UsuarioModel> getUsarios(){
        return this.userService.getUsersBank();
    }

    @PostMapping("/getdinamicpass")
    public String obtenerClaveDinamica(@RequestBody UserName request){
        String nombreUsuario= request.getNombreUsuario();
        String account= userService.getDinamicPass(nombreUsuario);
        return account;
    }

    @PostMapping("/cambiarestado")
    public ResponseEntity<String> cambiarEstado(@RequestBody EstadoUsuario request){
        String cedula= request.getCedula();
        String estado= request.getEstado();
        String tipo_usuario = request.getTipo_usuario();

        boolean esValido = userService.cambiarEstadoUsuario(cedula, tipo_usuario, estado);

        if(esValido){
            return ResponseEntity.ok("Estado de Cuenta Cambiado");
        }
        else{
            return ResponseEntity.status(401).body("No ha sido cambiado");
        }
    }

}
