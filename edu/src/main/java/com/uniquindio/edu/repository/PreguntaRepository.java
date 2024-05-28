package com.uniquindio.edu.repository;

import com.uniquindio.edu.model.OpcionPregunta;
import com.uniquindio.edu.model.Pregunta;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PreguntaRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SimpleJdbcCall jdbcCall;

    @PostConstruct
    public void init() {
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_obtener_preguntas_examen")
                .declareParameters(new SqlOutParameter("p_result", Types.REF_CURSOR, new PreguntasResultSetExtractor()));
    }

    private static final String CREATE_QUESTION_SQL = "CALL sp_crear_pregunta(?, ?, ?, ?, ?, ?)";
    private static final String ASSOCIATE_QUESTION_SQL = "CALL sp_agregar_pregunta_examen(?, ?, ?)";
    private static final String CREATE_OPTION_SQL = "CALL sp_agregar_opcion_pregunta(?, ?, ?)";

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

    public void associateQuestionWithExam(String examenId, String preguntaId, int porcentaje) {
        jdbcTemplate.update(ASSOCIATE_QUESTION_SQL, examenId, preguntaId, porcentaje);
    }

    public void createOption(String textoOpcion, String idPregunta, char esCorrecta) {
        jdbcTemplate.update(CREATE_OPTION_SQL, textoOpcion, idPregunta, esCorrecta);
    }

    public List<Pregunta> findPreguntasByExamenId(String idExamen) {
        Map<String, Object> inParams = new HashMap<>();
        inParams.put("p_examen_id", idExamen);

        Map<String, Object> out = jdbcCall.execute(new MapSqlParameterSource(inParams));
        return (List<Pregunta>) out.get("p_result");
    }

    private static class PreguntasResultSetExtractor implements ResultSetExtractor<List<Pregunta>> {
        @Override
        public List<Pregunta> extractData(ResultSet rs) throws SQLException {
            Map<String, Pregunta> preguntaMap = new HashMap<>();
            while (rs.next()) {
                String idPregunta = rs.getString("id_pregunta");
                Pregunta pregunta = preguntaMap.get(idPregunta);
                if (pregunta == null) {
                    pregunta = new Pregunta();
                    pregunta.setIdPregunta(idPregunta);
                    pregunta.setTextoPregunta(rs.getString("texto_pregunta"));
                    pregunta.setDuracion(rs.getInt("duracion"));
                    pregunta.setPorcentaje(rs.getInt("porcentaje"));
                    pregunta.setPrivada(rs.getBoolean("privada"));
                    pregunta.setTipoPregunta(rs.getString("tipo_pregunta_id_tipo"));
                    pregunta.setOpciones(new ArrayList<>()); // Inicializar la lista de opciones
                    preguntaMap.put(idPregunta, pregunta);
                }

                OpcionPregunta opcion = new OpcionPregunta();
                opcion.setIdOpcion(rs.getString("id_opcion"));
                opcion.setTextoOpcion(rs.getString("texto_opcion"));
                opcion.setEsCorrecta(rs.getBoolean("es_correcta"));

                pregunta.getOpciones().add(opcion); // Agregar la opción a la lista de opciones
            }
            return new ArrayList<>(preguntaMap.values());
        }
    }
}

