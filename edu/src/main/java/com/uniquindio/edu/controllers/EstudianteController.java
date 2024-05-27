package com.uniquindio.edu.controllers;

import com.uniquindio.edu.model.Examen;
import com.uniquindio.edu.model.Pregunta;
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
public class EstudianteController {

    @Autowired
    private ExamenService examenService;

    @GetMapping("/seleccionar-examen")
    public ResponseEntity<List<Examen>> examenesPendientes(@RequestParam("idUsuario") String idUsuario) {
        List<Examen> examenes = examenService.getPendingExams(idUsuario);
        System.out.println(examenes);
        return ResponseEntity.ok(examenes);
    }

    @GetMapping("/presentar-examen")
    public ResponseEntity<List<Pregunta>> presentarExamen(@RequestParam("idExamen") String idExamen) {
        System.out.println(idExamen);
        List<Pregunta> preguntas = examenService.getPreguntas(idExamen);
        return ResponseEntity.ok(preguntas);
    }
}
