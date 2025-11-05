package com.proyecto.hoja.estilo.proyectoHojaEstilo.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;

import lombok.*;


@Entity
@Table(name = "inscripciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaInscripcion = LocalDateTime.now();

    private boolean activo = true; // indica si el alumno sigue inscrito

    private Double calificacion; // opcional, si deseas guardar nota final

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    @ToString.Exclude
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id", nullable = false)
    @ToString.Exclude
    private Curso curso;
}
