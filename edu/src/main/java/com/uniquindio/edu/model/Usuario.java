package com.uniquindio.edu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    private String idUsuario;

    private String correo;

    private String clave;

    private Rol rol;
}

