package com.uniquindio.edu.repository;

import com.uniquindio.edu.model.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class RolRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String SELECT_ROLE_BY_ID_SQL = "SELECT id_rol, nombre FROM Roles WHERE id_rol = ?";

    public Rol findById(String roleId) {
        return jdbcTemplate.queryForObject(SELECT_ROLE_BY_ID_SQL, new RolRowMapper(), roleId);
    }

    private static class RolRowMapper implements RowMapper<Rol> {
        @Override
        public Rol mapRow(ResultSet rs, int rowNum) throws SQLException {
            Rol rol = new Rol();
            rol.setIdRole(Integer.parseInt(rs.getString("id_rol")));
            rol.setRole(rs.getString("nombre"));
            return rol;
        }
    }
}
