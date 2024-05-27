package com.uniquindio.edu.service;

import com.uniquindio.edu.model.Docente;
import com.uniquindio.edu.model.Estudiante;
import com.uniquindio.edu.repository.DocenteRepository;
import com.uniquindio.edu.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    public List<Docente> obtenerTodosLosDocentes() {
        return docenteRepository.findAll();
    }

    public Optional<Docente> obtenerDocentePorId(String id) {
        return docenteRepository.findById(id);
    }

    public Docente guardarDocente(Docente docente) {
        return docenteRepository.save(docente);
    }

    public void eliminarDocente(String id) {
        docenteRepository.deleteById(id);
    }
}
