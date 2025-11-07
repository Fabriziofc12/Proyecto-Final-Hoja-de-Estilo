package com.proyecto.hoja.estilo.proyectoHojaEstilo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;


@Entity
@Table(name = "cursos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descripcion;

    private String nivel;

    private String imagen;

    private LocalDate fechaPublicacion;

    private int numeroClases;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor; // Asociación con el profesor
}


