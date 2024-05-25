package com.uniquindio.edu.service;

import com.uniquindio.edu.model.RespuestaEstudiante;
import com.uniquindio.edu.model.RespuestaEstudianteId;
import com.uniquindio.edu.repository.RespuestaEstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespuestaEstudianteService {

    @Autowired
    private RespuestaEstudianteRepository respuestaEstudianteRepository;

    public List<RespuestaEstudiante> obtenerTodasLasRespuestasEstudiantes() {
        return respuestaEstudianteRepository.findAll();
    }

    public Optional<RespuestaEstudiante> obtenerRespuestaEstudiantePorId(RespuestaEstudianteId id) {
        return respuestaEstudianteRepository.findById(id);
    }

    public RespuestaEstudiante guardarRespuestaEstudiante(RespuestaEstudiante respuestaEstudiante) {
        return respuestaEstudianteRepository.save(respuestaEstudiante);
    }

    public void eliminarRespuestaEstudiante(RespuestaEstudianteId id) {
        respuestaEstudianteRepository.deleteById(id);
    }
}
