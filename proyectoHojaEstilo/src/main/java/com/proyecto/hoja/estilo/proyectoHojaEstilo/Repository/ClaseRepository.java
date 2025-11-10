package com.proyecto.hoja.estilo.proyectoHojaEstilo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Clase;

@Repository
public interface ClaseRepository extends JpaRepository<Clase,Long>{
    
}
