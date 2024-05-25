package com.uniquindio.edu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CONTENIDOS")
public class Contenido {
    @Id
    @Column(name = "ID_CONTENIDO")
    private String idContenido;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "UNIDADES_ID_UNIDAD", referencedColumnName = "ID_UNIDAD")
    private Unidad unidad;
}
