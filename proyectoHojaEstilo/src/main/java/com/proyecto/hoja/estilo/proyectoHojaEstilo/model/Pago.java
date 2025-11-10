package com.proyecto.hoja.estilo.proyectoHojaEstilo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "pagos")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    
    @NotNull(message = "El total no puede ser nulo.")
    @DecimalMin(value = "0.01", message = "El total debe ser mayor que 0.")
    @Column(nullable = false, precision = 12, scale = 2)
    private double monto;

    @NotNull(message = "Debe seleccionarse un método de pago.")
    private String metodoPago; // tarjeta, paypal, etc.
    
    private LocalDateTime fechaPago;
    private String descripcion; // "Plan mensual", "Curso X"
}

