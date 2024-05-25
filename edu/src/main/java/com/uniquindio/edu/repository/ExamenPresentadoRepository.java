package com.uniquindio.edu.repository;

import com.uniquindio.edu.model.ExamenPresentado;
import com.uniquindio.edu.model.RespuestaEstudiante;
import com.uniquindio.edu.model.RespuestaEstudianteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamenPresentadoRepository extends JpaRepository<ExamenPresentado, Long> {
}
