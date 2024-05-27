package com.uniquindio.edu.controllers;

import com.uniquindio.edu.model.Usuario;
import com.uniquindio.edu.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/")
public class UserController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String login() {
        System.out.println("log");
        return "OK";
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestParam String username, @RequestParam String password) {
        Usuario usuario = usuarioService.login(username, password);
        System.out.println(usuario);
        return ResponseEntity.ok(usuario);
    }
}
