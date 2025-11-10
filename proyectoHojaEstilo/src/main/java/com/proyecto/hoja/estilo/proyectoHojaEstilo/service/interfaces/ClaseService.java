package com.proyecto.hoja.estilo.proyectoHojaEstilo.service.interfaces;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Clase;
import java.util.List;

public interface ClaseService {
    Clase crearClase(Clase clase);
    Clase actualizarClase(Long id, Clase clase);
    void eliminarClase(Long id);
    Clase obtenerPorId(Long id);
    List<Clase> listarPorCurso(Long cursoId);
}