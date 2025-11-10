package com.proyecto.hoja.estilo.proyectoHojaEstilo.DTO;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class RegistroUsuarioDTO {

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String apellido;

    @Email(message = "Debe ser un correo válido")
    @NotBlank(message = "El correo es obligatorio")
    private String correo;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String password;
    
}
