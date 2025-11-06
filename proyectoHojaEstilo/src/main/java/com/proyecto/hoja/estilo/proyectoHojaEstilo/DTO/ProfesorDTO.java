package com.proyecto.hoja.estilo.proyectoHojaEstilo.DTO;


import lombok.Data;

@Data
public class ProfesorDTO {
    private Long id;
    private String nombreCompleto;
    private String especialidad;
    private String nacionalidad;
    private String descripcion;
    private String imagenPerfil;
    private String correoInstitucional;
}

