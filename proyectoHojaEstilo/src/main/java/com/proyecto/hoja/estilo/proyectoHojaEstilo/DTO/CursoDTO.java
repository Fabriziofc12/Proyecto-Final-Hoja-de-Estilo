package com.proyecto.hoja.estilo.proyectoHojaEstilo.DTO;

import lombok.Data;

@Data
public class CursoDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private String nivel;
    private String imagen;
    private String profesorNombre; // Relación con Profesor
    private String fechaPublicacion;
    private int numeroClases;
}
