package com.uniquindio.edu.repository;

import com.uniquindio.edu.model.Horario;
import com.uniquindio.edu.model.TipoPregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPreguntaRepository extends JpaRepository<TipoPregunta, Integer> {
}
