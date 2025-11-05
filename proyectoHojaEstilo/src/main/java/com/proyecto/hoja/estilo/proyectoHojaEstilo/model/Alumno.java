package com.proyecto.hoja.estilo.proyectoHojaEstilo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCompleto;
    private String nacionalidad;
    private String correoElectronico;
    private String contrasena;

    private String tipoAcceso; // gratuito, plan mensual, plan anual
    private String imagenPerfil;
    private LocalDate fechaNacimiento;
}

