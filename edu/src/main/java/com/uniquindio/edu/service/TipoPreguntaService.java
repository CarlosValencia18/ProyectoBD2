package com.uniquindio.edu.service;

import com.uniquindio.edu.model.Horario;
import com.uniquindio.edu.model.TipoPregunta;
import com.uniquindio.edu.repository.HorarioRepository;
import com.uniquindio.edu.repository.TipoPreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoPreguntaService {

    @Autowired
    private TipoPreguntaRepository tipoPreguntaRepository;

    public List<TipoPregunta> obtenerTodosLosTiposDePregunta() {
        return tipoPreguntaRepository.findAll();
    }

    public Optional<TipoPregunta> obtenerTipoPreguntaPorId(Integer id) {
        return tipoPreguntaRepository.findById(id);
    }

    public TipoPregunta guardarTipoPregunta(TipoPregunta tipoPregunta) {
        return tipoPreguntaRepository.save(tipoPregunta);
    }

    public void eliminarTipoPregunta(Integer id) {
        tipoPreguntaRepository.deleteById(id);
    }
}

