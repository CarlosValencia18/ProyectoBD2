package com.uniquindio.edu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamenPresentado {

    private Long idExamenPresentado;

    private Timestamp fechaPresentacion;

    private int calificacion;

    private int tiempoTomado;

    private String direccionIp;

    private Examen examenAsignado;

    private Estudiante estudiante;

    private Grupo grupo;
}
