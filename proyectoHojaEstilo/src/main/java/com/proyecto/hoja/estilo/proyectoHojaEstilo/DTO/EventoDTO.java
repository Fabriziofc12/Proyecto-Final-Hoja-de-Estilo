package com.proyecto.hoja.estilo.proyectoHojaEstilo.DTO;


import lombok.Data;

@Data
public class EventoDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private String tipo;
    private String imagen;
    private java.time.LocalDateTime horario;
}


