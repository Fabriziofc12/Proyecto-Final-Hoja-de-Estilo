package com.proyecto.hoja.estilo.proyectoHojaEstilo.service;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.DTO.RegistroDTO;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Rol;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Usuario;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.repository.UsuarioRepository;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.service.interfaces.UsuarioService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
 private final UsuarioRepository usuarioRepository;
 private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Optional<Usuario> obtenerPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    @Override
    public Usuario registrarNuevoUsuario(RegistroDTO dto) {
        if (usuarioRepository.findByCorreo(dto.getCorreo()).isPresent()) {
            throw new IllegalArgumentException("Ya existe un usuario con este correo.");
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setApellido(dto.getApellido());
        usuario.setCorreo(dto.getCorreo());
        usuario.setContrasena(passwordEncoder.encode(dto.getPassword()));
        usuario.setRol(Rol.ALUMNO);

        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario(Long id, Usuario usuario) {
        return usuarioRepository.findById(id)
            .map(existing -> {
                existing.setNombre(usuario.getNombre());
                existing.setCorreo(usuario.getCorreo());
                existing.setContrasena(usuario.getContrasena());
                return usuarioRepository.save(existing);
            })
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario login(String correo, String password) {
        return usuarioRepository.findByCorreo(correo)
                .filter(u -> u.getContrasena().equals(password))
                .orElse(null);
    }

    
}
