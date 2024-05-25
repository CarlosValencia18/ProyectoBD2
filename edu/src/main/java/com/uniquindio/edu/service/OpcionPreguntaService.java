package com.uniquindio.edu.service;

import com.uniquindio.edu.model.BancoDePreguntas;
import com.uniquindio.edu.model.OpcionPregunta;
import com.uniquindio.edu.repository.BancoDePreguntasRepository;
import com.uniquindio.edu.repository.OpcionPreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OpcionPreguntaService {

    @Autowired
    private OpcionPreguntaRepository opcionPreguntaRepository;

    public List<OpcionPregunta> obtenerTodasLasOpcionesPregunta() {
        return opcionPreguntaRepository.findAll();
    }

    public Optional<OpcionPregunta> obtenerOpcionPreguntaPorId(String id) {
        return opcionPreguntaRepository.findById(id);
    }

    public OpcionPregunta guardarOpcionPregunta(OpcionPregunta opcionPregunta) {
        return opcionPreguntaRepository.save(opcionPregunta);
    }

    public void eliminarOpcionPregunta(String id) {
        opcionPreguntaRepository.deleteById(id);
    }
}
