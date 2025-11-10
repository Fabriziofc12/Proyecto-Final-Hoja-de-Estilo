package com.proyecto.hoja.estilo.proyectoHojaEstilo.services;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> listarTodos();
    Optional<Usuario> buscarPorId(Long id);
    Optional<Usuario> buscarPorCorreo(String correo);
    Usuario guardar(Usuario usuario);
    Usuario actualizar(Usuario usuario);
    void eliminar(Long id);
    Usuario login(String correo, String password);
}
