package com.uniquindio.edu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Horario {

    private String idHorario;

    private Timestamp horaInicio;

    private Timestamp horaFin;

    private String diaSemana;

    private String lugar;

    private Grupo grupo;
}
