package com.proyecto.hoja.estilo.proyectoHojaEstilo.controllers;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.DTO.LoginDTO;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.DTO.UsuarioDTO;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Usuario;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.service.interfaces.UsuarioService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UsuarioService usuarioService;
    private final ModelMapper modelMapper;

    @GetMapping("/login")
    public String mostrarLogin(Model model) {
        model.addAttribute("loginDTO", new LoginDTO());
        return "login";
    }

    @PostMapping("/login")
    public String procesarLogin(@Valid @ModelAttribute("loginDTO") LoginDTO dto,
                                BindingResult result, HttpSession session, Model model) {

        if (result.hasErrors()) return "login";

        Optional<Usuario> optionalUsuario = usuarioService.obtenerPorCorreo(dto.getCorreo());
        if (optionalUsuario.isEmpty() || 
            !optionalUsuario.get().getContrasena().equals(dto.getPassword())) {
            model.addAttribute("error", "Correo o contraseña incorrectos");
            return "login";
        }

        Usuario usuario = optionalUsuario.get();
        UsuarioDTO usuarioDTO = modelMapper.map(usuario, UsuarioDTO.class);
        session.setAttribute("usuarioLogueado", usuarioDTO);

        return "redirect:/usuario";
    }

    @GetMapping("/logout")
    public String cerrarSesion(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
