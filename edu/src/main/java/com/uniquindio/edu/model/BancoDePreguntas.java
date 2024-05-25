package com.uniquindio.edu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BANCOS_DE_PREGUNTAS")
public class BancoDePreguntas {
    @Id
    @Column(name = "ID_BANCO_PREGUNTAS")
    private String idBancoPreguntas;

    @ManyToOne
    @JoinColumn(name = "TEMAS_ID_TEMA", referencedColumnName = "ID_TEMA")
    private Tema tema;

    @Column(name = "NOMBRE")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "DOCENTES_ID_DOCENTE", referencedColumnName = "ID_DOCENTE")
    private Docente docente;
}

