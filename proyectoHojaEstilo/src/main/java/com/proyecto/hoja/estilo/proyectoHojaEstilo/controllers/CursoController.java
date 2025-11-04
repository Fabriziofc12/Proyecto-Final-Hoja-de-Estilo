package com.proyecto.hoja.estilo.proyectoHojaEstilo.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CursoController {

    private final List<Map<String, String>> cursos = new ArrayList<Map<String, String>>();

    public CursoController() {
        Map<String, String> curso1 = new HashMap<String, String>();
        curso1.put("id", "1");
        curso1.put("titulo", "Desarrollo Web");
        curso1.put("descripcion", "HTML, CSS, JS y frameworks modernos");
        curso1.put("imagen", "https://images.unsplash.com/photo-1584697964403-c8b9eaf5e85c");
        cursos.add(curso1);

        Map<String, String> curso2 = new HashMap<String, String>();
        curso2.put("id", "2");
        curso2.put("titulo", "React Avanzado");
        curso2.put("descripcion", "Hooks, Context y ecosistema moderno");
        curso2.put("imagen", "https://images.unsplash.com/photo-1519389950473-47ba0277781c");
        cursos.add(curso2);

        Map<String, String> curso3 = new HashMap<String, String>();
        curso3.put("id", "3");
        curso3.put("titulo", "Python para Principiantes");
        curso3.put("descripcion", "Fundamentos y primeros proyectos");
        curso3.put("imagen", "https://images.unsplash.com/photo-1551434678-e076c223a692");
        cursos.add(curso3);
    }

    @GetMapping("/Cursos")
    public String listarCursos(Model model) {
        model.addAttribute("cursos", cursos);
        return "cursos";
    }

    @GetMapping("/Cursos/{id}")
public String detalleCurso(@PathVariable String id, Model model) {
    // Buscar el curso en la lista (tu implementación actual)
    Map<String, String> curso = null;
    for (Map<String, String> c : cursos) {
        if (c.get("id").equals(id)) {
            curso = c;
            break;
        }
    }

    if (curso == null) {
        return "redirect:/Cursos";
    }

    // Ejemplo: contenido por curso (puedes cargar desde DB luego)
    List<String> contenido;
    switch (id) {
        case "1":
            contenido = Arrays.asList(
                "Introducción al desarrollo web",
                "HTML5 y estructura semántica",
                "CSS moderno y responsive",
                "JavaScript: fundamentos y DOM",
                "Proyecto: Landing responsiva"
            );
            break;
        case "2":
            contenido = Arrays.asList(
                "Fundamentos de React y JSX",
                "Componentes y props",
                "Hooks: useState, useEffect",
                "Context API + manejo de estado",
                "Despliegue y buenas prácticas"
            );
            break;
        case "3":
            contenido = Arrays.asList(
                "Sintaxis básica y tipos",
                "Estructuras de control",
                "Funciones, módulos y paquetes",
                "Manejo de archivos y librerías",
                "Proyecto final: automatización"
            );
            break;
        default:
            contenido = Arrays.asList(
                "Módulo 1",
                "Módulo 2",
                "Módulo 3"
            );
    }

    model.addAttribute("curso", curso);
    model.addAttribute("contenido", contenido);

    return "curso-detalle";
}

}
