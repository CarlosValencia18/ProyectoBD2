package com.uniquindio.edu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USUARIOS")
public class Usuario {
    @Id
    @Column(name = "ID_USUARIO")
    private String idUsuario;

    @Column(name = "CORREO")
    private String correo;

    @Column(name = "CLAVE")
    private String clave;

    @ManyToOne
    @JoinColumn(name = "ROLES_ID_ROLE", referencedColumnName = "ID_ROLE")
    private Rol rol;
}

