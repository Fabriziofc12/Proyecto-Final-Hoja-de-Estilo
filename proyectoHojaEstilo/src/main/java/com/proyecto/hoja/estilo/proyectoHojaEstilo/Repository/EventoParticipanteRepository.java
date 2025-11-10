package com.proyecto.hoja.estilo.proyectoHojaEstilo.Repository;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.EventoParticipante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoParticipanteRepository extends JpaRepository<EventoParticipante, Long> {
}
