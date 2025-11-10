package com.proyecto.hoja.estilo.proyectoHojaEstilo.services;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Usuario;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.Repository.UsuarioRepository;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired(required = false)
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Optional<Usuario> buscarPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        if (usuario.getPassword() != null && passwordEncoder != null) {
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario login(String correo, String password) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreo(correo);
        if (usuarioOpt.isEmpty()) return null;
        Usuario usuario = usuarioOpt.get();
        if (passwordEncoder != null && passwordEncoder.matches(password, usuario.getPassword())) {
            return usuario;
        }
        return null;
    }
}
