package com.uniquindio.edu.service;

import com.uniquindio.edu.model.BancoDePreguntas;
import com.uniquindio.edu.model.Examen;
import com.uniquindio.edu.model.Pregunta;
import com.uniquindio.edu.repository.ExamenRepository;
import com.uniquindio.edu.repository.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ExamenService {

    @Autowired
    private ExamenRepository examenRepository;

    @Autowired
    private PreguntaRepository preguntaRepository;

    public List<Examen> getExamsByTeacherId(String teacherId) {
        return examenRepository.findExamsByTeacherId(teacherId);
    }

    public List<BancoDePreguntas> getQuestionBanksByTeacherId(String teacherId) {
        return examenRepository.findQuestionBanksByTeacherId(teacherId);
    }

    public List<Examen> getPendingExams(String studentId) {
        return examenRepository.findPendingExamsByStudentId(studentId);
    }

    public String createExam(String nombre, String descripcion, String categoria, int duracion, int numPreguntas, int numPreguntasAleatorias, int umbralAprobacion, String docenteId, String idTema) {
        return examenRepository.createExam(nombre, descripcion, categoria, duracion, numPreguntas, numPreguntasAleatorias, umbralAprobacion, docenteId, idTema);
    }

    public void assignExam(String examenId, String grupoId, Date fechaInicio, Date fechaFin, int peso) {
        examenRepository.assignExam(examenId, grupoId, fechaInicio, fechaFin, peso);
    }

    public List<Pregunta> getPreguntas(String idExamen) {
        return preguntaRepository.findPreguntasByExamenId(idExamen);
    }
}

