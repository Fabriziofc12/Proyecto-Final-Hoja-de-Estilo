package com.proyecto.hoja.estilo.proyectoHojaEstilo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {
    @GetMapping("/Index")
    public String getIndex(Model model) {
            model.addAttribute("titulo", "Página de Inicio");
            model.addAttribute("header", "Logo");
            model.addAttribute("contenido", "Landing Page");
        return "Index";
    }
    
}
