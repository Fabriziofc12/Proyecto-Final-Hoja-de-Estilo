package com.proyecto.hoja.estilo.proyectoHojaEstilo.service.interfaces;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Inscripcion;
import java.util.List;
import java.util.Optional;

public interface InscripcionService {

    List<Inscripcion> listarInscripciones();

    Optional<Inscripcion> obtenerPorId(Long id);

    Inscripcion guardarInscripcion(Inscripcion inscripcion);

    Inscripcion actualizarInscripcion(Long id, Inscripcion inscripcionActualizada);

    void eliminarInscripcion(Long id);

    // Métodos adicionales de utilidad:
    List<Inscripcion> listarPorUsuario(Long usuarioId);
    List<Inscripcion> listarPorCurso(Long cursoId);
}