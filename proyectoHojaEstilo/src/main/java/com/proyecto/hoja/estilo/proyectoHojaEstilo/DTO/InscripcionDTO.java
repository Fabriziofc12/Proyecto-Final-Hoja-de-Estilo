package com.proyecto.hoja.estilo.proyectoHojaEstilo.DTO;


import lombok.Data;
import java.time.LocalDateTime;

@Data
public class InscripcionDTO {
    private Long id;
    private Long usuarioId;
    private Long cursoId;
    private LocalDateTime fechaInscripcion;
}
