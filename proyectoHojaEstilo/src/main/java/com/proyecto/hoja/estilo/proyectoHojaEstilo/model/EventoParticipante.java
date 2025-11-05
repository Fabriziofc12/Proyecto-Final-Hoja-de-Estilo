package com.proyecto.hoja.estilo.proyectoHojaEstilo.model;

import jakarta.persistence.*;
import lombok.ToString;
import java.time.LocalDateTime;
import lombok.*;


@Entity
@Table(name = "evento_participantes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventoParticipante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaRegistro = LocalDateTime.now();

    private boolean asistio = false; // marca si el usuario asistió al evento

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    @ToString.Exclude
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evento_id", nullable = false)
    @ToString.Exclude
    private Evento evento;
}
