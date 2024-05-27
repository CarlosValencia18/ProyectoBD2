package com.uniquindio.edu.service;

import com.uniquindio.edu.model.Contenido;
import com.uniquindio.edu.model.Tema;
import com.uniquindio.edu.repository.ContenidoRepository;
import com.uniquindio.edu.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContenidoService {

    @Autowired
    private ContenidoRepository contenidoRepository;

}

