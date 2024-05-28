package com.uniquindio.edu.service;

import com.uniquindio.edu.repository.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreguntaService {

    @Autowired
    private PreguntaRepository preguntaRepository;

    public Long createQuestion(String textoPregunta, int tipoPreguntaId, int duracion, char privada, String preguntasIdPregunta) {
        return preguntaRepository.createQuestion(textoPregunta, tipoPreguntaId, duracion, privada, preguntasIdPregunta);
    }

    public void associateQuestionWithExam(String examenId, String preguntaId, int porcentaje) {
        preguntaRepository.associateQuestionWithExam(examenId, preguntaId, porcentaje);
    }

    public void createOption(String textoOpcion, String idPregunta, char esCorrecta) {
        preguntaRepository.createOption(textoOpcion, idPregunta, esCorrecta);
    }
}

