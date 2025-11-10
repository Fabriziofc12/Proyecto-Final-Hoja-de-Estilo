package com.proyecto.hoja.estilo.proyectoHojaEstilo.Repository;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreo(String correo);
    boolean existsByCorreo(String correo);
    
}
