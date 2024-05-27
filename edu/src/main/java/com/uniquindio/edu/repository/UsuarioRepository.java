package com.uniquindio.edu.repository;

import com.uniquindio.edu.model.Rol;
import com.uniquindio.edu.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UsuarioRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_USER_SQL = "CALL sp_registrar_usuario(?, ?, ?, ?, ?, ?)";
    private static final String LOGIN_USER_SQL = "SELECT autenticar_usuario(?, ?) FROM DUAL";
    private static final String FIND_STUDENT_BY_ID_SQL = "SELECT * FROM VW_DETALLES_ESTUDIANTE WHERE id_estudiante = ?";
    private static final String FIND_TEACHER_BY_ID_SQL = "SELECT * FROM VW_DETALLES_DOCENTE WHERE id_docente = ?";

    public void register(Usuario usuario, String nombres, String apellidos, String telefono) {
        jdbcTemplate.update(INSERT_USER_SQL,
                usuario.getCorreo(),
                usuario.getClave(),
                usuario.getRol().getIdRole(),
                nombres,
                apellidos,
                telefono);
    }

    public String login(String correo, String clave) {
        return jdbcTemplate.queryForObject(LOGIN_USER_SQL, new Object[]{correo, clave}, String.class);
    }

    public Usuario findStudentById(String idUsuario) {
        return jdbcTemplate.queryForObject(FIND_STUDENT_BY_ID_SQL, new Object[]{idUsuario}, new UsuarioRowMapper());
    }

    public Usuario findTeacherById(String idUsuario) {
        return jdbcTemplate.queryForObject(FIND_TEACHER_BY_ID_SQL, new Object[]{idUsuario}, new UsuarioRowMapper());
    }

    private static class UsuarioRowMapper implements RowMapper<Usuario> {
        @Override
        public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(rs.getString("id_usuario"));
            usuario.setCorreo(rs.getString("correo"));
            usuario.setClave(rs.getString("clave"));

            Rol rol = new Rol();
            rol.setIdRole(Integer.parseInt(rs.getString("Roles_id_role")));
            rol.setRole(rs.getString("nombre_rol"));

            usuario.setRol(rol);
            return usuario;
        }
    }
}

