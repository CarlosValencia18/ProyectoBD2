package com.uniquindio.edu.service;

import com.uniquindio.edu.model.ExamenAsignado;
import com.uniquindio.edu.model.Horario;
import com.uniquindio.edu.repository.ExamenAsignadoRepository;
import com.uniquindio.edu.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

}

