package com.uniquindio.edu.service;

import com.uniquindio.edu.model.Grupo;
import com.uniquindio.edu.model.Unidad;
import com.uniquindio.edu.repository.GrupoRepository;
import com.uniquindio.edu.repository.UnidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    public List<Grupo> obtenerTodosLosGrupos() {
        return grupoRepository.findAll();
    }

    public Optional<Grupo> obtenerGrupoPorId(String id) {
        return grupoRepository.findById(id);
    }

    public Grupo guardarGrupo(Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    public void eliminarGrupo(String id) {
        grupoRepository.deleteById(id);
    }
}

