package com.uniquindio.edu.repository;

import com.uniquindio.edu.model.Examen;
import com.uniquindio.edu.model.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamenRepository extends JpaRepository<Examen, String> {
}

