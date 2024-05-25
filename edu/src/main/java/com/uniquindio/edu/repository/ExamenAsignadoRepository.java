package com.uniquindio.edu.repository;

import com.uniquindio.edu.model.ExamenAsignado;
import com.uniquindio.edu.model.ExamenPresentado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamenAsignadoRepository extends JpaRepository<ExamenAsignado, Long> {
}
