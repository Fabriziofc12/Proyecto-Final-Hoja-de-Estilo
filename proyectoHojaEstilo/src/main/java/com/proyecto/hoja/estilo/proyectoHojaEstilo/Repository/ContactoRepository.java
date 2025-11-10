package com.proyecto.hoja.estilo.proyectoHojaEstilo.repository;


import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Long> {
}

