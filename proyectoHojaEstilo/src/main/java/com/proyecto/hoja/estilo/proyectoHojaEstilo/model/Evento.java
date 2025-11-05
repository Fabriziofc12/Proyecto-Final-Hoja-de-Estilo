package com.proyecto.hoja.estilo.proyectoHojaEstilo.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table(name = "eventos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;
    private String ubicacion;

    private LocalDate fecha;
    private double precio;

    @ManyToMany(mappedBy = "eventos")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Usuario> asistentes;
}

