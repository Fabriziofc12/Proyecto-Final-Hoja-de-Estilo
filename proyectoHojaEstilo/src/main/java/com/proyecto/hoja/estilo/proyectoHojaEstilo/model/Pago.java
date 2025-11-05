package com.proyecto.hoja.estilo.proyectoHojaEstilo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;




@Entity
@Table(name = "pagos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double monto;

    private LocalDateTime fechaPago;

    @Enumerated(EnumType.STRING)
    private MetodoPago metodo;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = true)
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "evento_id", nullable = true)
    private Evento evento;
}
