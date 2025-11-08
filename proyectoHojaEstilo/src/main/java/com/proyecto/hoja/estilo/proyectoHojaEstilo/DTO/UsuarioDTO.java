package com.proyecto.hoja.estilo.proyectoHojaEstilo.DTO;


import lombok.Data;

@Data
public class UsuarioDTO {
    private Long id;
    private String nombreCompleto;
    private String correoElectronico;
    private String tipoAcceso; // Ej: ADMIN, ALUMNO
    private String nacionalidad;
    private String imagenPerfil;
}
