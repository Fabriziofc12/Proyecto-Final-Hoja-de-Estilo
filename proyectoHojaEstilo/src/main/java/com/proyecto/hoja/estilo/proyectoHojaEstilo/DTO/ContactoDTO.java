package com.proyecto.hoja.estilo.proyectoHojaEstilo.DTO;


import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class ContactoDTO {

    @Email(message = "Debe ingresar un correo válido")
    @NotBlank(message = "El correo es obligatorio")
    private String correo;

    @NotBlank(message = "El mensaje no puede estar vacío")
    private String mensaje;
}
