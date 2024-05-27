package com.uniquindio.edu.repository;

import com.uniquindio.edu.model.OpcionPregunta;
import com.uniquindio.edu.model.Pregunta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.*;

@Repository
public class PreguntaRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String CREATE_QUESTION_SQL = "CALL sp_crear_pregunta(?, ?, ?, ?, ?, ?)";
    private static final String ASSOCIATE_QUESTION_SQL = "CALL sp_asociar_pregunta_examen(?, ?, ?)";

    public Long createQuestion(String textoPregunta, int tipoPreguntaId, int duracion, char privada, String preguntasIdPregunta) {
        return jdbcTemplate.execute((ConnectionCallback<Long>) connection -> {
            try (CallableStatement cs = connection.prepareCall(CREATE_QUESTION_SQL)) {
                cs.setString(1, textoPregunta);
                cs.setInt(2, tipoPreguntaId);
                cs.setInt(3, duracion);
                cs.setString(4, String.valueOf(privada));
                cs.setString(5, preguntasIdPregunta);
                cs.registerOutParameter(6, Types.NUMERIC);
                cs.execute();
                return cs.getLong(6);
            }
        });
    }

    public void associateQuestionWithExam(String examenId, Long preguntaId, float porcentaje) {
        jdbcTemplate.update(ASSOCIATE_QUESTION_SQL, examenId, preguntaId, porcentaje);
    }
}

