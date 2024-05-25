package com.uniquindio.edu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CURSOS")
public class Curso {
    @Id
    @Column(name = "ID_CURSO")
    private String idCurso;

    @Column(name = "NOMBRE")
    private String nombre;
}

