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

    public List<Pregunta> obtenerTodasLasPreguntas() {
        return preguntaRepository.findAll();
    }

    public Optional<Pregunta> obtenerPreguntaPorId(String id) {
        return preguntaRepository.findById(id);
    }

    public Pregunta guardarPregunta(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    public void eliminarPregunta(String id) {
        preguntaRepository.deleteById(id);
    }
}

