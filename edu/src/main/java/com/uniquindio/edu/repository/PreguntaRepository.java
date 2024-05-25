package com.uniquindio.edu.repository;

import com.uniquindio.edu.model.OpcionPregunta;
import com.uniquindio.edu.model.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, String> {
}

