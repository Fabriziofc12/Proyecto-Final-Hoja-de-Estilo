package com.proyecto.hoja.estilo.proyectoHojaEstilo.DTO;

import lombok.Data;

@Data
public class ClaseDTO {
    private Long id;
    private String titulo;
    private String videoUrl;
    private String resumen;
    private int orden; // posición dentro del curso
}

