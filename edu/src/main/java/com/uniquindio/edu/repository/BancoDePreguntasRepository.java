package com.uniquindio.edu.repository;

import com.uniquindio.edu.model.BancoDePreguntas;
import com.uniquindio.edu.model.TipoPregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BancoDePreguntasRepository extends JpaRepository<BancoDePreguntas, String> {
}
