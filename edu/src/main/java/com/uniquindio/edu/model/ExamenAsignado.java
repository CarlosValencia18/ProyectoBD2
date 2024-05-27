package com.uniquindio.edu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamenAsignado {

    private Long idExamenAsignado;

    private Examen examen;

    private Grupo grupo;

    private Timestamp fechaInicio;

    private Timestamp fechaFin;

    private int peso;
}
