package com.proyecto.hoja.estilo.proyectoHojaEstilo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlanesController {

    @GetMapping("/Planes")
    public String mostrarPlanes(Model model) {
        // Si más adelante tienes una tabla Plan en la BD, puedes pasarla así:
        // List<Plan> planes = planService.listarPlanes();
        // model.addAttribute("planes", planes);

        return "planes"; // ← nombre del archivo HTML (sin .html)
    }
}
