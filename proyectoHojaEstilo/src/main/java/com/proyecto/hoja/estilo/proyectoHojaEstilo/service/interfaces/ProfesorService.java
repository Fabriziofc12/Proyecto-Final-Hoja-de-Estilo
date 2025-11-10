package com.proyecto.hoja.estilo.proyectoHojaEstilo.service.interfaces;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Profesor;
import java.util.List;
import java.util.Optional;

public interface ProfesorService {
    List<Profesor> listarProfesores();
    Optional<Profesor> obtenerPorId(Long id);
    Profesor guardarProfesor(Profesor profesor);
    Profesor actualizarProfesor(Long id, Profesor profesor);
    void eliminarProfesor(Long id);
}
