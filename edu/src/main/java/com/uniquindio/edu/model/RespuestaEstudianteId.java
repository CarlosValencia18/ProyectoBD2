package com.uniquindio.edu.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class RespuestaEstudianteId implements Serializable {
    private Long examenPresentado;
    private Long pregunta;
    private Long opcionPregunta;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RespuestaEstudianteId that = (RespuestaEstudianteId) o;
        return Objects.equals(examenPresentado, that.examenPresentado) &&
                Objects.equals(pregunta, that.pregunta) &&
                Objects.equals(opcionPregunta, that.opcionPregunta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(examenPresentado, pregunta, opcionPregunta);
    }
}
