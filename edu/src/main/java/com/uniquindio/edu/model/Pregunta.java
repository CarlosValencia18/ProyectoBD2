package com.uniquindio.edu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Pregunta {

    private String idPregunta;

    private String textoPregunta;

    private int duracion;

    private int porcentaje;

    private boolean privada;

    private Pregunta preguntaPadre;

    private String tipoPregunta;

    private List<OpcionPregunta> opciones;
}
