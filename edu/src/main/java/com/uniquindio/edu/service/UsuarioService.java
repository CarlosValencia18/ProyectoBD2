package com.uniquindio.edu.service;

import com.uniquindio.edu.model.Rol;
import com.uniquindio.edu.model.Usuario;
import com.uniquindio.edu.repository.RolRepository;
import com.uniquindio.edu.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    public void register(String correo, String clave, String roleId, String nombres, String apellidos, String telefono) {
        Rol rol = rolRepository.findById(String.valueOf(roleId));

        Usuario usuario = new Usuario();
        usuario.setCorreo(correo);
        usuario.setClave(clave);
        usuario.setRol(rol);

        usuarioRepository.register(usuario, nombres, apellidos, telefono);
    }

    public Usuario login(String correo, String clave) {
        String idUsuario = usuarioRepository.login(correo, clave);
        if (idUsuario == null) {
            throw new IllegalArgumentException("Invalid email or password");
        }
        Usuario usuario = usuarioRepository.findById(idUsuario);
        Rol rol = rolRepository.findById(String.valueOf(usuario.getRol().getIdRole()));

        if (rol.getIdRole() == 3) {
            usuario = usuarioRepository.findStudentById(idUsuario);
        } else if (rol.getIdRole() == 2) {
            usuario = usuarioRepository.findTeacherById(idUsuario);
        } else {
            throw new IllegalArgumentException("Unknown role ID");
        }

        return usuario;
    }

}

