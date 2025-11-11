package com.proyecto.hoja.estilo.proyectoHojaEstilo.DTO;


import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class LoginDTO {

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Debe ingresar un correo válido")
    private String correo;

    @NotBlank(message = "Debe ingresar su contraseña")
    private String password;
}
