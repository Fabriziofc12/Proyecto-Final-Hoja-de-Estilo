package com.proyecto.hoja.estilo.proyectoHojaEstilo.controllers;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.DTO.LoginDTO;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.DTO.UsuarioDTO;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Usuario;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.service.interfaces.UsuarioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final UsuarioService usuarioService;
    private final ModelMapper modelMapper;

    @GetMapping
    public String mostrarLogin(Model model) {
        model.addAttribute("loginDTO", new LoginDTO());
        return "login";
    }

    @PostMapping
    public String procesarLogin(@Valid @ModelAttribute("loginDTO") LoginDTO dto,BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "login";
        }

        // Buscar usuario por correo
        Optional<Usuario> optionalUsuario = usuarioService.obtenerPorCorreo(dto.getCorreo());

        if (optionalUsuario.isEmpty()) {
            model.addAttribute("error", "Correo o contraseña incorrectos");
            return "login";
        }

        Usuario usuario = optionalUsuario.get();

        // Validar contraseña (sin seguridad aún, comparación simple)
        if (!usuario.getContrasena().equals(dto.getPassword())) {
            model.addAttribute("error", "Correo o contraseña incorrectos");
            return "login";
        }

        // Si todo está correcto, redirigir al panel de usuario
        model.addAttribute("usuario", modelMapper.map(usuario, UsuarioDTO.class));
        return "redirect:/usuario";
    }

}
