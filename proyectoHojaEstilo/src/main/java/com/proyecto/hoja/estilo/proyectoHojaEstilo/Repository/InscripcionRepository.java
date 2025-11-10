package com.proyecto.hoja.estilo.proyectoHojaEstilo.Repository;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
}

