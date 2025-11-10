package com.proyecto.hoja.estilo.proyectoHojaEstilo.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "clases")
public class Clase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String videoUrl;

    @Column(length = 1000)
    private String descripcion;

    private int orden; // número de clase dentro del curso

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @Column(nullable = false)
    private Integer numeroClase;
}

