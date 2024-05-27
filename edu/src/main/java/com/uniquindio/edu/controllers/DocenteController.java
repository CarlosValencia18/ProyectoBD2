package com.uniquindio.edu.controllers;

import com.uniquindio.edu.model.Examen;
import com.uniquindio.edu.model.Pregunta;
import com.uniquindio.edu.service.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PostMapping("/crear-examen")
    @ResponseBody
    public ResponseEntity<String> crearExamen(@RequestBody Map<String, Object> examForApi) {

        // Obtener los datos del examen directamente de examForApi
        String examName = (String) examForApi.get("examName");
        String examDescription = (String) examForApi.get("examDescription");
        String examCategory = (String) examForApi.get("examCategory");
        Integer questionCount = (Integer) examForApi.get("questionCount");
        Integer examDuration = (Integer) examForApi.get("examDuration");

        // Imprimir los datos del examen para verificar
        System.out.println("Nombre del examen: " + examName);
        System.out.println("Descripción del examen: " + examDescription);
        System.out.println("Categoría del examen: " + examCategory);
        System.out.println("Cantidad de preguntas: " + questionCount);
        System.out.println("Duración del examen: " + examDuration);

        // Obtener las preguntas
        List<Map<String, Object>> preguntasData = (List<Map<String, Object>>) examForApi.get("preguntas");
        System.out.println("Datos de las preguntas: " + preguntasData);

        // Crear el examen
        Examen examen = new Examen();
        // ... establecer las demás propiedades del examen ...

        // Crear las preguntas
        for (Map<String, Object> preguntaData : preguntasData) {
            Pregunta pregunta = new Pregunta();
            // ... establecer las demás propiedades de la pregunta ...

        }

        // Guardar el examen y las preguntas en la base de datos
        return ResponseEntity.ok("Examen creado exito");
    }

}
