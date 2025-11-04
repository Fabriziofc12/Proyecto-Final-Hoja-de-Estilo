package com.proyecto.hoja.estilo.proyectoHojaEstilo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class UsuarioController {

    @GetMapping("/Usuario")
    public String mostrarPerfil(Model model) {

        // Datos de usuario simulados (puedes luego obtenerlos desde la BD)
        Map<String, String> usuario = new HashMap<>();
        usuario.put("nombre", "Juan Pérez");
        usuario.put("correo", "juanperez@email.com");

        // Lista de cursos registrados
        List<Map<String, String>> cursos = new ArrayList<>();
        cursos.add(Map.of(
                "nombre", "Desarrollo Web",
                "descripcion", "Aprende HTML, CSS y JavaScript desde cero.",
                "id", "1"
        ));
        cursos.add(Map.of(
                "nombre", "Python Avanzado",
                "descripcion", "Programación orientada a objetos y proyectos reales.",
                "id", "2"
        ));
        cursos.add(Map.of(
                "nombre", "Bases de Datos SQL",
                "descripcion", "Domina consultas, relaciones y modelado de datos.",
                "id", "3"
        ));

        // Lista de eventos registrados
        List<Map<String, String>> eventos = new ArrayList<>();
        eventos.add(Map.of(
                "titulo", "Webinar de Inteligencia Artificial",
                "fecha", "15 de noviembre de 2025",
                "hora", "6:00 p.m."
        ));
        eventos.add(Map.of(
                "titulo", "Taller de UI/UX",
                "fecha", "20 de diciembre de 2025",
                "hora", "3:00 p.m."
        ));

        // Agregar al modelo
        model.addAttribute("usuario", usuario);
        model.addAttribute("cursosRegistrados", cursos);
        model.addAttribute("eventosRegistrados", eventos);

        return "usuario"; // Thymeleaf buscará usuario.html en /templates
    }

    @PostMapping("/Usuario/Actualizar")
    public String actualizarPerfil(
            @RequestParam("nombre") String nombre,
            @RequestParam("correo") String correo,
            @RequestParam("password") String password,
            Model model) {

        // Aquí podrías guardar los cambios en la base de datos.
        System.out.println("Actualizando usuario:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Correo: " + correo);
        System.out.println("Contraseña: " + password);

        // Simular datos actualizados
        Map<String, String> usuario = new HashMap<>();
        usuario.put("nombre", nombre);
        usuario.put("correo", correo);

        model.addAttribute("usuario", usuario);
        model.addAttribute("mensaje", "Datos actualizados correctamente.");

        // Vuelve a cargar cursos y eventos (en un caso real vendrían de la BD)
        mostrarPerfil(model);

        return "usuario";
    }
}
