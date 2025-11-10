package com.proyecto.hoja.estilo.proyectoHojaEstilo.service.interfaces;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Curso;
import java.util.List;
import java.util.Optional;

public interface CursoService {
    List<Curso> listarCursos();
    Optional<Curso> obtenerPorId(Long id);
    Curso guardarCurso(Curso curso);
    Curso actualizarCurso(Long id, Curso curso);
    void eliminarCurso(Long id);
}


