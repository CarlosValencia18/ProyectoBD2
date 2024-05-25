package com.uniquindio.edu.service;

import com.uniquindio.edu.model.Tema;
import com.uniquindio.edu.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TemaService {

    @Autowired
    private TemaRepository temaRepository;

    public List<Tema> obtenerTodosLosTemas() {
        return temaRepository.findAll();
    }

    public Optional<Tema> obtenerTemaPorId(String id) {
        return temaRepository.findById(id);
    }

    public Tema guardarTema(Tema tema) {
        return temaRepository.save(tema);
    }

    public void eliminarTema(String id) {
        temaRepository.deleteById(id);
    }
}
