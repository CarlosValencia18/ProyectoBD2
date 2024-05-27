package com.uniquindio.edu.controllers;

import com.uniquindio.edu.model.Usuario;
import com.uniquindio.edu.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class AngularController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public String OK() {
        System.out.println("OK");
        return "OK";
    }

    @GetMapping("/login")
    public ResponseEntity<String> login() {
        return ResponseEntity.ok("usuario");
    }

}


