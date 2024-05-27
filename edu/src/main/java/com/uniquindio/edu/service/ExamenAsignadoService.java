package com.uniquindio.edu.service;

import com.uniquindio.edu.model.ExamenAsignado;
import com.uniquindio.edu.model.ExamenPresentado;
import com.uniquindio.edu.repository.ExamenAsignadoRepository;
import com.uniquindio.edu.repository.ExamenPresentadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenAsignadoService {

    @Autowired
    private ExamenAsignadoRepository examenAsignadoRepository;


}

