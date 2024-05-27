package com.uniquindio.edu.service;

import com.uniquindio.edu.model.Curso;
import com.uniquindio.edu.model.Grupo;
import com.uniquindio.edu.repository.CursoRepository;
import com.uniquindio.edu.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

}

