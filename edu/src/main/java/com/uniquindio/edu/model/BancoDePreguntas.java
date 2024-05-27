package com.uniquindio.edu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BancoDePreguntas {

    private String idBancoPreguntas;

    private Tema tema;

    private String nombre;

    private Docente docente;
}

