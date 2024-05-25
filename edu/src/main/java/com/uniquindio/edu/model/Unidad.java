package com.uniquindio.edu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "UNIDADES")
public class Unidad {
    @Id
    @Column(name = "ID_UNIDAD")
    private String idUnidad;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "CURSOS_ID_CURSO", referencedColumnName = "ID_CURSO")
    private Curso curso;
}

