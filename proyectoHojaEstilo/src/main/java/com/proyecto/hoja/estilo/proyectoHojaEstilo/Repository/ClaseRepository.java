package com.proyecto.hoja.estilo.proyectoHojaEstilo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Clase;

@Repository
public interface ClaseRepository extends JpaRepository<Clase,Long>{
    List<Clase> findByCursoIdOrderByNumeroClaseAsc(Long cursoId);
    int countByCursoId(Long cursoId);
}
