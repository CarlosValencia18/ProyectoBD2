package com.uniquindio.edu.repository;

import com.uniquindio.edu.model.Docente;
import com.uniquindio.edu.model.Estudiante;
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
    private static final String FIND_STUDENT_BY_ID_SQL = "SELECT * FROM VW_ESTUDIANTES WHERE id_usuario = ?";
    private static final String FIND_TEACHER_BY_ID_SQL = "SELECT * FROM VW_PROFESORES WHERE id_usuario = ?";

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
        return jdbcTemplate.queryForObject(FIND_STUDENT_BY_ID_SQL, new Object[]{idUsuario}, new EstudianteRowMapper());
    }

    public Usuario findTeacherById(String idUsuario) {
        return jdbcTemplate.queryForObject(FIND_TEACHER_BY_ID_SQL, new Object[]{idUsuario}, new DocenteRowMapper());
    }

    public Usuario findById(String idUsuario) {
        return jdbcTemplate.queryForObject("SELECT * FROM USUARIOS WHERE id_usuario = ?", new Object[]{idUsuario}, new UsuarioRowMapper());
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

            usuario.setRol(rol);
            return usuario;
        }
    }

    private static class EstudianteRowMapper implements RowMapper<Usuario> {
        @Override
        public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
            System.out.println(rs.getString("id_estudiante"));
            Usuario usuario = new Estudiante();
            usuario.setIdUsuario(rs.getString("id_estudiante"));
            usuario.setCorreo(rs.getString("correo"));
            return usuario;
        }
    }

    private static class DocenteRowMapper implements RowMapper<Usuario> {
        @Override
        public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {

            Usuario usuario = new Docente();
            usuario.setIdUsuario(rs.getString("id_docente"));
            usuario.setCorreo(rs.getString("correo"));
            return usuario;
        }
    }
}

