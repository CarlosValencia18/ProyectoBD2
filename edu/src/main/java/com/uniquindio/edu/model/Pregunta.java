package com.uniquindio.edu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PREGUNTAS")
public class Pregunta {
    @Id
    @Column(name = "ID_PREGUNTA")
    private String idPregunta;

    @Column(name = "TEXTO_PREGUNTA")
    private String textoPregunta;

    @Column(name = "DURACION")
    private int duracion;

    @Column(name = "PORCENTAJE")
    private int porcentaje;

    @Column(name = "PRIVADA")
    private boolean privada;

    @ManyToOne
    @JoinColumn(name = "PREGUNTAS_ID_PREGUNTA", referencedColumnName = "ID_PREGUNTA")
    private Pregunta preguntaPadre;

    @ManyToOne
    @JoinColumn(name = "TIPO_PREGUNTA_ID_TIPO", referencedColumnName = "ID_TIPO")
    private TipoPregunta tipoPregunta;
}
