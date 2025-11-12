package com.proyecto.hoja.estilo.proyectoHojaEstilo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;






@Controller
public class HomeController {
    @GetMapping("/")
    public String getIndexDefault() {
        return "Index";
    }
    @GetMapping("/Index")
    public String getIndex() {
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
    @GetMapping("/Cursos")
    public String getCursos() {
        return "Cursos";
    }
    

}
