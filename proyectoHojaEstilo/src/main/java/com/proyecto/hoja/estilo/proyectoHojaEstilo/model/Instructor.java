package com.proyecto.hoja.estilo.proyectoHojaEstilo.model;


import jakarta.persistence.*;

import lombok.*;

import java.util.List;



@Entity
@Table(name = "instructores")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String especialidad;
    private String biografia;

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Curso> cursos;
}

