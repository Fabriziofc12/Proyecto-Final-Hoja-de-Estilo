package com.proyecto.hoja.estilo.proyectoHojaEstilo.Repository;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
