package com.proyecto.hoja.estilo.proyectoHojaEstilo.services;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Curso;
import java.util.List;
import java.util.Optional;

public interface CursoService {
    List<Curso> listarTodos();
    Optional<Curso> buscarPorId(Long id);
    Curso guardar(Curso curso);
    void eliminar(Long id);
}

