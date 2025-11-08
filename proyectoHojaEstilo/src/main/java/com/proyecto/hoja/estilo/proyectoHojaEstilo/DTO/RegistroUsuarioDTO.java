package com.proyecto.hoja.estilo.proyectoHojaEstilo.DTO;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class RegistroUsuarioDTO {

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombreCompleto;

    @Email(message = "Debe ser un correo válido")
    @NotBlank(message = "El correo es obligatorio")
    private String correoElectronico;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String password;

    @NotBlank(message = "Debe seleccionar su nacionalidad")
    private String nacionalidad;

    @Past(message = "La fecha de nacimiento debe ser anterior a hoy")
    private java.time.LocalDate fechaNacimiento;
}
