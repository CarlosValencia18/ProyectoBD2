package com.uniquindio.edu.service;

import com.uniquindio.edu.model.Docente;
import com.uniquindio.edu.model.Examen;
import com.uniquindio.edu.model.Rol;
import com.uniquindio.edu.repository.DocenteRepository;
import com.uniquindio.edu.repository.ExamenRepository;
import com.uniquindio.edu.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> obtenerTodosLosRoles() {
        return rolRepository.findAll();
    }

    public Optional<Rol> obtenerRolPorId(Integer id) {
        return rolRepository.findById(id);
    }

    public Rol guardarRol(Rol rol) {
        return rolRepository.save(rol);
    }

    public void eliminarRol(Integer id) {
        rolRepository.deleteById(id);
    }
}

