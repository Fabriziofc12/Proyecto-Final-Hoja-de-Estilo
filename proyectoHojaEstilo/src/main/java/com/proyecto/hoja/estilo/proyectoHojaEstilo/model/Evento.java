package com.proyecto.hoja.estilo.proyectoHojaEstilo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String tipo;
    private String descripcion;
    private String imagen;
    private LocalDateTime fechaHora;
    private String enlace;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    private List<EventoParticipante> participantes;
}


