package com.uniquindio.edu.repository;

import com.uniquindio.edu.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, String> {
}

