package com.proyecto.hoja.estilo.proyectoHojaEstilo.repository;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findByNombreContainingIgnoreCase(String nombre);
}

