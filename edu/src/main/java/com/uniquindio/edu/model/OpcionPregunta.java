package com.uniquindio.edu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OPCIONES_PREGUNTA")
public class OpcionPregunta {
    @Id
    @Column(name = "ID_OPCION")
    private String idOpcion;

    @Column(name = "TEXTO_OPCION")
    private String textoOpcion;

    @Column(name = "ES_CORRECTA")
    private boolean esCorrecta;

    @ManyToOne
    @JoinColumn(name = "PREGUNTAS_ID_PREGUNTA", referencedColumnName = "ID_PREGUNTA")
    private Pregunta pregunta;
}
