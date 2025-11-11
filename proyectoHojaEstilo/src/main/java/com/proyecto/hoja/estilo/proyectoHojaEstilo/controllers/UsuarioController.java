package com.proyecto.hoja.estilo.proyectoHojaEstilo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;      

import com.proyecto.hoja.estilo.proyectoHojaEstilo.DTO.UsuarioDTO;

import jakarta.servlet.http.HttpSession;



@Controller
public class UsuarioController {
        @GetMapping("/usuario")
        public String panelUsuario(HttpSession session, Model model) {
        UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuarioLogueado");
        if (usuario == null) {
                return "redirect:/login";
        }
        model.addAttribute("usuario", usuario);
        return "usuario";
        }
}
