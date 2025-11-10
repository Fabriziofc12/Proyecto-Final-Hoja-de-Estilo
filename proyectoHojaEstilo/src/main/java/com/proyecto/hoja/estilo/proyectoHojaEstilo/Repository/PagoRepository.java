package com.proyecto.hoja.estilo.proyectoHojaEstilo.repository;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
}
