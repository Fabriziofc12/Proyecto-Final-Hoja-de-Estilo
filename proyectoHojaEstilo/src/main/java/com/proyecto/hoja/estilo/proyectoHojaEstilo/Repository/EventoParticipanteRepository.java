package com.proyecto.hoja.estilo.proyectoHojaEstilo.repository;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.EventoParticipante;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoParticipanteRepository extends JpaRepository<EventoParticipante, Long> {
    List<EventoParticipante> findByEventoId(Long eventoId);
    List<EventoParticipante> findByUsuarioId(Long usuarioId);
}
