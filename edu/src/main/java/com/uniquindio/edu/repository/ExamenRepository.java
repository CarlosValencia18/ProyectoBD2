package com.uniquindio.edu.repository;

import com.uniquindio.edu.model.BancoDePreguntas;
import com.uniquindio.edu.model.Examen;
import com.uniquindio.edu.model.Pregunta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class ExamenRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String FIND_PENDING_EXAMS_BY_STUDENT_ID_SQL = "SELECT * FROM VW_EXAMENES_PENDIENTES WHERE Estudiantes_id_estudiante = ?";
    private static final String FIND_EXAMS_BY_TEACHER_ID_SQL = "SELECT * FROM VW_EXAMENES_CREADOS_DOCENTE WHERE Docentes_id_docente = ?";
    private static final String FIND_QUESTION_BANKS_BY_TEACHER_ID_SQL = "SELECT * FROM VW_BANCOS_PREGUNTAS_DOCENTE WHERE Docentes_id_docente = ?";
    private static final String CREATE_EXAM_SQL = "CALL sp_crear_examen(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String ASSIGN_EXAM_SQL = "CALL sp_asignar_examen(?, ?, ?, ?, ?)";

    public List<Examen> findExamsByTeacherId(String teacherId) {
        return jdbcTemplate.query(FIND_EXAMS_BY_TEACHER_ID_SQL, new Object[]{teacherId}, new ExamenRowMapper());
    }

    public List<BancoDePreguntas> findQuestionBanksByTeacherId(String teacherId) {
        return jdbcTemplate.query(FIND_QUESTION_BANKS_BY_TEACHER_ID_SQL, new Object[]{teacherId}, new BancoPreguntasRowMapper());
    }

    public List<Examen> findPendingExamsByStudentId(String studentId) {
        return jdbcTemplate.query(FIND_PENDING_EXAMS_BY_STUDENT_ID_SQL, new Object[]{studentId}, new ExamenRowMapper());
    }

    public String createExam(String nombre, String descripcion, String categoria, int duracion, int numPreguntas, int numPreguntasAleatorias, float umbralAprobacion, String docenteId) {
        return jdbcTemplate.execute((ConnectionCallback<String>) connection -> {
            try (CallableStatement cs = connection.prepareCall(CREATE_EXAM_SQL)) {
                cs.setString(1, nombre);
                cs.setString(2, descripcion);
                cs.setString(3, categoria);
                cs.setInt(4, duracion);
                cs.setInt(5, numPreguntas);
                cs.setInt(6, numPreguntasAleatorias);
                cs.setFloat(7, umbralAprobacion);
                cs.setString(8, docenteId);
                cs.registerOutParameter(9, Types.VARCHAR);
                cs.execute();
                return cs.getString(9);
            }
        });
    }

    public void assignExam(String examenId, String grupoId, Date fechaInicio, Date fechaFin, int peso) {
        jdbcTemplate.update(ASSIGN_EXAM_SQL, examenId, grupoId, fechaInicio, fechaFin, peso);
    }

    private static class ExamenRowMapper implements RowMapper<Examen> {
        @Override
        public Examen mapRow(ResultSet rs, int rowNum) throws SQLException {
            Examen examen = new Examen();
            examen.setIdExamen(rs.getString("id_examen"));
            examen.setNombre(rs.getString("nombre"));
            examen.setDescripcion(rs.getString("descripcion"));
            examen.setCategoria(rs.getString("categoria"));
            examen.setDuracion(rs.getInt("duracion"));
            examen.setNumPreguntas(rs.getInt("num_preguntas"));
            examen.setNumPreguntasAleatorias(rs.getInt("num_preguntas_aleatorias"));
            examen.setUmbralAprobacion(rs.getInt("umbral_aprobacion"));
            return examen;
        }
    }
    private static class BancoPreguntasRowMapper implements RowMapper<BancoDePreguntas> {
        @Override
        public BancoDePreguntas mapRow(ResultSet rs, int rowNum) throws SQLException {
            BancoDePreguntas bancoPreguntas = new BancoDePreguntas();
            bancoPreguntas.setIdBancoPreguntas(rs.getString("id_banco_preguntas"));
            bancoPreguntas.setNombre(rs.getString("nombre"));
            return bancoPreguntas;
        }
    }
}

