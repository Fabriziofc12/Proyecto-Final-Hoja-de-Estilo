package com.proyecto.hoja.estilo.proyectoHojaEstilo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "profesores")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombreCompleto;

    @NotBlank
    private String especialidad;

    private String nacionalidad;

    @Column(length = 1000)
    private String descripcion;

    private String imagenPerfil;

    @Column(unique = true)
    private String correoInstitucional;

    // El admin puede asignar una contraseña, pero no se usa para login
    private String contrasena;
}

