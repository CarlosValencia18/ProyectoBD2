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
@Table(name = "EXAMENES_PRESENTADOS")
public class ExamenPresentado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EXAMEN_PRESENTADO")
    private Long idExamenPresentado;

    @Column(name = "FECHA_PRESENTACION")
    private Timestamp fechaPresentacion;

    @Column(name = "CALIFICACION")
    private int calificacion;

    @Column(name = "TIEMPO_TOMADO")
    private int tiempoTomado;

    @Column(name = "DIRECCION_IP")
    private String direccionIp;

    @ManyToOne
    @JoinColumn(name = "EXAM_ASIGNADOS_EXAM_ID_EXAM", referencedColumnName = "ID_EXAMEN")
    private Examen examenAsignado;

    @ManyToOne
    @JoinColumn(name = "ESTUDIANTES_ID_ESTUDIANTE", referencedColumnName = "ID_ESTUDIANTE")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "EXAM_ASIGNADO_GRUP_ID_GRUP", referencedColumnName = "ID_GRUPO")
    private Grupo grupo;
}
