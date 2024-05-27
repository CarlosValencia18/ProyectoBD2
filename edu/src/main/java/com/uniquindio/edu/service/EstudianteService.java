package com.uniquindio.edu.service;

import com.uniquindio.edu.model.Curso;
import com.uniquindio.edu.model.Estudiante;
import com.uniquindio.edu.repository.CursoRepository;
import com.uniquindio.edu.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

}
