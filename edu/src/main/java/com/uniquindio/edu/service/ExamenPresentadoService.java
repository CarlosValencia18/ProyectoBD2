package com.uniquindio.edu.service;

import com.uniquindio.edu.model.ExamenPresentado;
import com.uniquindio.edu.model.RespuestaEstudiante;
import com.uniquindio.edu.model.RespuestaEstudianteId;
import com.uniquindio.edu.repository.ExamenPresentadoRepository;
import com.uniquindio.edu.repository.RespuestaEstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenPresentadoService {

    @Autowired
    private ExamenPresentadoRepository examenPresentadoRepository;

    public List<ExamenPresentado> obtenerTodosLosExamenesPresentados() {
        return examenPresentadoRepository.findAll();
    }

    public Optional<ExamenPresentado> obtenerExamenPresentadoPorId(Long id) {
        return examenPresentadoRepository.findById(id);
    }

    public ExamenPresentado guardarExamenPresentado(ExamenPresentado examenPresentado) {
        return examenPresentadoRepository.save(examenPresentado);
    }

    public void eliminarExamenPresentado(Long id) {
        examenPresentadoRepository.deleteById(id);
    }
}
