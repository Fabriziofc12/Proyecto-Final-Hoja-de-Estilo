package com.proyecto.hoja.estilo.proyectoHojaEstilo.DTO;


import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PagoDTO {
    private Long id;
    private Double monto;
    private String metodoPago;
    private String estado;
    private LocalDateTime fechaPago;
    private Long usuarioId;
    private String referencia;
}


