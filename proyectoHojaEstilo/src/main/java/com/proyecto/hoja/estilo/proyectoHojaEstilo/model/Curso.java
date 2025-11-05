package com.proyecto.hoja.estilo.proyectoHojaEstilo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import lombok.*;



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
    private String imagen;

    private double precio;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    // Un curso puede tener varios alumnos inscritos
    @ManyToMany(mappedBy = "cursos")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Usuario> alumnos;
}
