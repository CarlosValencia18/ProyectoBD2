package com.uniquindio.edu.service;

import com.uniquindio.edu.model.OpcionPregunta;
import com.uniquindio.edu.model.Pregunta;
import com.uniquindio.edu.repository.OpcionPreguntaRepository;
import com.uniquindio.edu.repository.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PreguntaService {

    @Autowired
    private PreguntaRepository preguntaRepository;

    public Long createQuestion(String textoPregunta, int tipoPreguntaId, int duracion, char privada, String preguntasIdPregunta) {
        return preguntaRepository.createQuestion(textoPregunta, tipoPreguntaId, duracion, privada, preguntasIdPregunta);
    }

    public void associateQuestionWithExam(String examenId, Long preguntaId, float porcentaje) {
        preguntaRepository.associateQuestionWithExam(examenId, preguntaId, porcentaje);
    }
}

