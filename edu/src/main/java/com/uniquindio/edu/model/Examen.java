package com.uniquindio.edu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Examen {

    private String idExamen;

    private String nombre;

    private String descripcion;

    private String categoria;

    private int duracion;

    private int numPreguntas;

    private int numPreguntasAleatorias;

    private int umbralAprobacion;

    private Tema tema;

    private Docente docente;
}

