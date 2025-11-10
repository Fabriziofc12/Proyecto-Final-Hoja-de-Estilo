package com.proyecto.hoja.estilo.proyectoHojaEstilo.service.interfaces;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.EventoParticipante;
import java.util.List;
import java.util.Optional;

public interface EventoParticipanteService {
    List<EventoParticipante> listarTodos();
    Optional<EventoParticipante> obtenerPorId(Long id);
    EventoParticipante guardar(EventoParticipante eventoParticipante);
    void eliminar(Long id);
    List<EventoParticipante> obtenerPorEvento(Long eventoId);
    List<EventoParticipante> obtenerPorUsuario(Long usuarioId);
}