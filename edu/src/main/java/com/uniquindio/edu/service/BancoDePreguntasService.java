package com.uniquindio.edu.service;

import com.uniquindio.edu.model.BancoDePreguntas;
import com.uniquindio.edu.model.TipoPregunta;
import com.uniquindio.edu.repository.BancoDePreguntasRepository;
import com.uniquindio.edu.repository.TipoPreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BancoDePreguntasService {

    @Autowired
    private BancoDePreguntasRepository bancoDePreguntasRepository;

}
