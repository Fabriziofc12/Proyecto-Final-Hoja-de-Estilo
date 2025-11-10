package com.proyecto.hoja.estilo.proyectoHojaEstilo.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Evento;

public interface EventoService {
    List<Evento> listarEventos();
    Optional<Evento> obtenerPorId(Long id);
    Evento guardarEvento(Evento evento);
    Evento actualizarEvento(Long id, Evento evento);
    void eliminarEvento(Long id);
}
