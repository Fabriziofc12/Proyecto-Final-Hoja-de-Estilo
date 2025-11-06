package com.proyecto.hoja.estilo.proyectoHojaEstilo.DTO;

import lombok.Data;
import java.time.LocalDate;

@Data
public class AlumnoRegistroDTO {
    private String nombreCompleto;
    private String nacionalidad;
    private String correoElectronico;
    private String contrasena;
    private String tipoAcceso; // Por ejemplo: "Básico", "Premium"
    private String imagenPerfil;
    private LocalDate fechaNacimiento;
}
