package com.uniquindio.edu.controllers;

import com.uniquindio.edu.model.Examen;
import com.uniquindio.edu.service.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/")
public class DocenteController {

    @Autowired
    private ExamenService examenService;

    @GetMapping("/inicio-docente")
    public ResponseEntity<List<Examen>> examenesPendientes(@RequestParam("idUsuario") String idUsuario) {
        List<Examen> examenes = examenService.getExamsByTeacherId(idUsuario);
        System.out.println(examenes);
        return ResponseEntity.ok(examenes);
    }

}
