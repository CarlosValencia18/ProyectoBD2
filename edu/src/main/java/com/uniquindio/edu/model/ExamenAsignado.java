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
@Table(name = "EXAMENES_ASIGNADOS")
public class ExamenAsignado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EXAMEN_ASIGNADO")
    private Long idExamenAsignado;

    @ManyToOne
    @JoinColumn(name = "EXAMENES_ID_EXAMEN", referencedColumnName = "ID_EXAMEN")
    private Examen examen;

    @ManyToOne
    @JoinColumn(name = "GRUPOS_ID_GRUPO", referencedColumnName = "ID_GRUPO")
    private Grupo grupo;

    @Column(name = "FECHA_INICIO")
    private Timestamp fechaInicio;

    @Column(name = "FECHA_FIN")
    private Timestamp fechaFin;

    @Column(name = "PESO")
    private int peso;
}
