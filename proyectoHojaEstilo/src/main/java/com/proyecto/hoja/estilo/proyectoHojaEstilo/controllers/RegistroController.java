package com.proyecto.hoja.estilo.proyectoHojaEstilo.controllers;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.DTO.RegistroDTO;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Usuario;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.service.interfaces.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registro")
public class RegistroController {

    @Autowired
    private UsuarioService usuarioService;

    // 🔹 Mostrar formulario de registro
    @GetMapping
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("registroDTO", new RegistroDTO());
        return "registro"; // nombre de tu vista HTML
    }

    // 🔹 Procesar formulario de registro
    @PostMapping
    public String procesarRegistro(
            @Valid @ModelAttribute("registroDTO") RegistroDTO dto,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            return "registro"; // vuelve al formulario con errores
        }

        try {
            Usuario nuevoUsuario = usuarioService.registrarNuevoUsuario(dto);
            model.addAttribute("usuario", nuevoUsuario);
            model.addAttribute("exito", "Registro exitoso. Ahora puedes iniciar sesión.");
            return "redirect:/login";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "registro";
        }
    }
}
