package com.proyecto.hoja.estilo.proyectoHojaEstilo.DTO;


import lombok.Data;

@Data
public class EventoDTO {
    private Long id;
    private String nombreEvento;
    private String tipoEvento;
    private String descripcion;
    private String imagen;
    private String horario;
}

