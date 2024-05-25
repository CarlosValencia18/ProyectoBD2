package com.uniquindio.edu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TEMAS")
public class Tema {
    @Id
    @Column(name = "ID_TEMA")
    private String idTema;

    @Column(name = "NOMBRE")
    private String nombre;
}

