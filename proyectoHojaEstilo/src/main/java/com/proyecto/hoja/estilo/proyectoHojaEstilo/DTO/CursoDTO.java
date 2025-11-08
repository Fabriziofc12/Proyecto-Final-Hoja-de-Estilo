package com.proyecto.hoja.estilo.proyectoHojaEstilo.DTO;


import lombok.Data;

@Data
public class CursoDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private String nivel;
    private String imagen;
    private Long profesorId;
    private java.time.LocalDate fechaPublicacion;
    private Integer numeroDeClases;
}
