package com.uniquindio.edu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante extends Usuario{

    private String idEstudiante;

    private String nombres;

    private String apellidos;

    private String telefono;

    private Usuario usuario;
}

