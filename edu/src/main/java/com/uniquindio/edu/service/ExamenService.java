package com.uniquindio.edu.service;

import com.uniquindio.edu.model.Examen;
import com.uniquindio.edu.model.Pregunta;
import com.uniquindio.edu.repository.ExamenRepository;
import com.uniquindio.edu.repository.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenService {

    @Autowired
    private ExamenRepository examenRepository;

    public List<Examen> obtenerTodosLosExamenes() {
        return examenRepository.findAll();
    }

    public Optional<Examen> obtenerExamenPorId(String id) {
        return examenRepository.findById(id);
    }

    public Examen guardarExamen(Examen examen) {
        return examenRepository.save(examen);
    }

    public void eliminarExamen(String id) {
        examenRepository.deleteById(id);
    }
}

