package com.uniquindio.edu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpcionPregunta {

    private String idOpcion;

    private String textoOpcion;

    private boolean esCorrecta;

    private Pregunta pregunta;
}
