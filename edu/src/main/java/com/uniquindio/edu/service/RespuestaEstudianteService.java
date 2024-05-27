package com.uniquindio.edu.service;

import com.uniquindio.edu.model.RespuestaEstudiante;
import com.uniquindio.edu.repository.RespuestaEstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespuestaEstudianteService {

    @Autowired
    private RespuestaEstudianteRepository respuestaEstudianteRepository;

}
