package com.uniquindio.edu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HORARIOS")
public class Horario {
    @Id
    @Column(name = "ID_HORARIO")
    private String idHorario;

    @Column(name = "HORA_INICIO")
    private Timestamp horaInicio;

    @Column(name = "HORA_FIN")
    private Timestamp horaFin;

    @Column(name = "DIA_SEMANA")
    private String diaSemana;

    @Column(name = "LUGAR")
    private String lugar;

    @ManyToOne
    @JoinColumn(name = "GRUPOS_ID_GRUPO", referencedColumnName = "ID_GRUPO")
    private Grupo grupo;
}
