package com.proyecto.hoja.estilo.proyectoHojaEstilo.service.interfaces;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> listarTodos();
    Optional<Usuario> obtenerPorId(Long id);
    Optional<Usuario> obtenerPorCorreo(String correo);
    Usuario registrarUsuario(Usuario usuario);
    Usuario actualizarUsuario(Long id, Usuario usuario);
    void eliminarUsuario(Long id);
    Usuario login(String correo, String password);
}

