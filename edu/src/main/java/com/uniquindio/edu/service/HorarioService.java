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

    public List<Horario> obtenerTodosLosHorarios() {
        return horarioRepository.findAll();
    }

    public Optional<Horario> obtenerHorarioPorId(String id) {
        return horarioRepository.findById(id);
    }

    public Horario guardarHorario(Horario horario) {
        return horarioRepository.save(horario);
    }

    public void eliminarHorario(String id) {
        horarioRepository.deleteById(id);
    }
}

