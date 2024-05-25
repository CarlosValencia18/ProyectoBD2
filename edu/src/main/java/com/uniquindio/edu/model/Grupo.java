package com.uniquindio.edu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "GRUPOS")
public class Grupo {
    @Id
    @Column(name = "ID_GRUPO")
    private String idGrupo;

    @ManyToOne
    @JoinColumn(name = "CURSOS_ID_CURSO", referencedColumnName = "ID_CURSO")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "DOCENTES_ID_DOCENTE", referencedColumnName = "ID_DOCENTE")
    private Docente docente;
}

