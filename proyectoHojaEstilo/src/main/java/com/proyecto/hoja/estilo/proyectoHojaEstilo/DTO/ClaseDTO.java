package com.proyecto.hoja.estilo.proyectoHojaEstilo.DTO;

import lombok.Data;

@Data
public class ClaseDTO {
    private Long id;
    private String titulo;
    private String resumen;
    private String videoUrl;
    private Integer orden;
    private Long cursoId;
}


