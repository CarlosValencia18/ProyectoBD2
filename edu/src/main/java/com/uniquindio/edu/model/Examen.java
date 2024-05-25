package com.uniquindio.edu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EXAMENES")
public class Examen {
    @Id
    @Column(name = "ID_EXAMEN")
    private String idExamen;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "CATEGORIA")
    private String categoria;

    @Column(name = "DURACION")
    private int duracion;

    @Column(name = "NUM_PREGUNTAS")
    private int numPreguntas;

    @Column(name = "NUM_PREGUNTAS_ALEATORIAS")
    private int numPreguntasAleatorias;

    @Column(name = "UMBRAL_APROBACION")
    private int umbralAprobacion;

    @ManyToOne
    @JoinColumn(name = "TEMAS_ID_TEMA", referencedColumnName = "ID_TEMA")
    private Tema tema;

    @ManyToOne
    @JoinColumn(name = "DOCENTES_ID_DOCENTE", referencedColumnName = "ID_DOCENTE")
    private Docente docente;
}

