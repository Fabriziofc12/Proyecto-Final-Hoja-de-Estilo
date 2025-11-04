package com.proyecto.hoja.estilo.proyectoHojaEstilo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class HomeController {
    @GetMapping("/Index")
    public String getIndex(Model model) {
            model.addAttribute("titulo", "Página de Inicio");
            model.addAttribute("header", "Logo");
            model.addAttribute("contenido", "Landing Page");
        return "Index";
    }
    @GetMapping("/Contacto")
    public String getContacto() {
        return "Contacto";
    }
    @GetMapping("/Instructores")
    public String getInstructores() {
        return "Instructores";
    }
    @GetMapping("/Eventos")
    public String getEventos() {
        return "Eventos";
    } 
}
