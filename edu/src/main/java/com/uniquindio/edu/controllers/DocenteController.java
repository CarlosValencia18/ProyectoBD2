package com.uniquindio.edu.controllers;

import com.uniquindio.edu.model.Examen;
import com.uniquindio.edu.service.ExamenService;
import com.uniquindio.edu.service.PreguntaService;
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

    @Autowired
    private PreguntaService preguntaService;

    @GetMapping("/inicio-docente")
    public ResponseEntity<List<Examen>> examenesPendientes(@RequestParam("idUsuario") String idUsuario) {
        List<Examen> examenes = examenService.getExamsByTeacherId(idUsuario);
        System.out.println(examenes);
        return ResponseEntity.ok(examenes);
    }

    @PostMapping("/crear-examen")
    @ResponseBody
    public ResponseEntity<String> crearExamen(@RequestBody Map<String, Object> examForApi) {
        String idExamen = examenService.createExam((String) examForApi.get("examName"), (String) examForApi.get("examDescription"), (String) examForApi.get("examCategory"), (Integer) examForApi.get("examDuration"), (Integer) examForApi.get("questionCount"), (Integer) examForApi.get("questionCount"), (Integer) examForApi.get("umbralAprobacion"), (String) examForApi.get("idUsuario"), (String) examForApi.get("examTema"));
        // Obtener las preguntas
        List<Map<String, Object>> preguntasData = (List<Map<String, Object>>) examForApi.get("preguntas");
        System.out.println("Datos de las preguntas: " + preguntasData);

        // Crear las preguntas
        for (Map<String, Object> preguntaData : preguntasData) {
            List<Map<String, Object>> opcionesData = (List<Map<String, Object>>) preguntaData.get("opciones");
            int tipoPregunta = 0;
            if(preguntaData.get("tipo").equals("trueFalse")) {
                tipoPregunta = 3;
            } else if (preguntaData.get("tipo").equals("multipleAnswers")) {
                tipoPregunta = 2;
            } else if (preguntaData.get("tipo").equals("multipleChoice")) {
                tipoPregunta = 1;
            }
            String idPregunta = String.valueOf(preguntaService.createQuestion((String) preguntaData.get("enunciado"), tipoPregunta, (int) preguntaData.get("duracion"), preguntaData.get("privada") == "true" ? 'Y' : 'N', null));
            preguntaService.associateQuestionWithExam(idExamen, idPregunta, preguntaData.get("duracion") != null ? ((Integer) preguntaData.get("duracion")).intValue() : 0);
            for(Object opcionDataObject : opcionesData) {
                if (opcionDataObject instanceof Map) {
                    Map<String, Object> opcionData = (Map<String, Object>) opcionDataObject;
                    preguntaService.createOption((String) opcionData.get("texto"), idPregunta,  opcionData.get("correcta").equals("true") ? 'Y' : 'N');
                } else if (opcionDataObject instanceof String opcionData) {
                    if(opcionData.equals("verdadero")) {
                        preguntaService.createOption("Verdadero", idPregunta, 'Y');
                        preguntaService.createOption("Falso", idPregunta, 'N');
                    } else {
                        preguntaService.createOption("Falso", idPregunta, 'Y');
                        preguntaService.createOption("Verdadero", idPregunta, 'N');
                    }
                } else {
                    System.out.println("Unexpected data format: " + opcionDataObject);
                }
            }
        }
        // Guardar el examen y las preguntas en la base de datos
        return ResponseEntity.ok("Examen creado exito");
    }

}
