package com.proyecto.hoja.estilo.proyectoHojaEstilo.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "profesor_detalle")
public class ProfesorDetalle {

    @Id
    private Long id; // mismo ID que el usuario

    @OneToOne
    @MapsId
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String especialidad;
    private String nacionalidad;
    private String descripcion;
    private String correoInstitucional;
}

