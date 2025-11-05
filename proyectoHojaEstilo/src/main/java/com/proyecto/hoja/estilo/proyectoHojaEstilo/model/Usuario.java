package com.proyecto.hoja.estilo.proyectoHojaEstilo.model;

import java.util.List;

import jakarta.persistence.*;


import lombok.*;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;

    @Column(unique = true, nullable = false)
    private String correo;

    @Column(nullable = false)
    private String contrasena;

    @Enumerated(EnumType.STRING)
    private Rol rol;  // ADMIN o ALUMNO

    private boolean activo = true;
    @ManyToMany
    @JoinTable(
        name = "usuarios_cursos",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Curso> cursos;

    @ManyToMany
    @JoinTable(
        name = "usuarios_eventos",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "evento_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Evento> eventos;

}


