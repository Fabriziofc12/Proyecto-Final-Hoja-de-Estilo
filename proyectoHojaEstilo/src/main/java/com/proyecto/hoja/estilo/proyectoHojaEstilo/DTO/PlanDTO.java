package com.proyecto.hoja.estilo.proyectoHojaEstilo.DTO;

import lombok.Data;
import java.time.LocalDate;

@Data
public class PlanDTO {
    private Long id;
    private String nombrePlan;
    private double precio;
    private String duracion; // "Mensual", "Anual"
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
}

