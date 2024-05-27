package com.uniquindio.edu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private TipoPregunta tipoPregunta;
}
