package com.proyecto.hoja.estilo.proyectoHojaEstilo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "alumno_detalle")
public class AlumnoDetalle {

    @Id
    private Long id; // mismo ID que el usuario

    @OneToOne
    @MapsId
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String nacionalidad;
    private String tipoAcceso; // "Básico" o "Premium"
    private String fechaNacimiento;
}

