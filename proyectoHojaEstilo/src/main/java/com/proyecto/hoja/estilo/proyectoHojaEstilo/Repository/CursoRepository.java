package com.proyecto.hoja.estilo.proyectoHojaEstilo.Repository;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByTituloContainingIgnoreCase(String titulo); // para buscador
}
