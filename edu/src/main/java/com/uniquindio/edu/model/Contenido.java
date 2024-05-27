package com.uniquindio.edu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Contenido {

    private String idContenido;

    private String titulo;

    private String descripcion;

    private Unidad unidad;
}
