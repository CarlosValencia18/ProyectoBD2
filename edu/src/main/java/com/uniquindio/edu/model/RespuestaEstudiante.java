package com.uniquindio.edu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RESPUESTAS_ESTUDIANTES")
public class RespuestaEstudiante {
    @EmbeddedId
    private RespuestaEstudianteId id;

    @ManyToOne
    @MapsId("examenPresentado")
    @JoinColumn(name = "EXAM_PRESENTADOS_ID_EXAM_PRES", referencedColumnName = "ID_EXAMEN_PRESENTADO")
    private ExamenPresentado examenPresentado;

    @ManyToOne
    @MapsId("pregunta")
    @JoinColumn(name = "PREGUNTAS_ID_PREGUNTA", referencedColumnName = "ID_PREGUNTA")
    private Pregunta pregunta;

    @ManyToOne
    @MapsId("opcionPregunta")
    @JoinColumn(name = "OPCIONES_PREGUNTA_ID_OPCION", referencedColumnName = "ID_OPCION")
    private OpcionPregunta opcionPregunta;
}
