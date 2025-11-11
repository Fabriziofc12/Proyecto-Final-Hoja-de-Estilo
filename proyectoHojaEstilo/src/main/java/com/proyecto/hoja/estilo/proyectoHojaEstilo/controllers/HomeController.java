package com.proyecto.hoja.estilo.proyectoHojaEstilo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.DTO.UsuarioDTO;

import jakarta.servlet.http.HttpSession;




@Controller
public class HomeController {
    
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
    @GetMapping("/registro")
    public String getRegistro() {
        return "registro";
    } 
    @GetMapping("/Cursos")
    public String getCursos() {
        return "Cursos";
    }
    

}
