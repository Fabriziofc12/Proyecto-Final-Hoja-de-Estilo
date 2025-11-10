package com.proyecto.hoja.estilo.proyectoHojaEstilo.repository;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Inscripcion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
    List<Inscripcion> findByUsuarioId(Long usuarioId);
    List<Inscripcion> findByCursoId(Long cursoId);
}

