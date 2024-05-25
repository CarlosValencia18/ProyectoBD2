package com.uniquindio.edu.service;

import com.uniquindio.edu.model.Contenido;
import com.uniquindio.edu.model.Unidad;
import com.uniquindio.edu.repository.ContenidoRepository;
import com.uniquindio.edu.repository.UnidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadService {

    @Autowired
    private UnidadRepository unidadRepository;

    public List<Unidad> obtenerTodasLasUnidades() {
        return unidadRepository.findAll();
    }

    public Optional<Unidad> obtenerUnidadPorId(String id) {
        return unidadRepository.findById(id);
    }

    public Unidad guardarUnidad(Unidad unidad) {
        return unidadRepository.save(unidad);
    }

    public void eliminarUnidad(String id) {
        unidadRepository.deleteById(id);
    }
}

