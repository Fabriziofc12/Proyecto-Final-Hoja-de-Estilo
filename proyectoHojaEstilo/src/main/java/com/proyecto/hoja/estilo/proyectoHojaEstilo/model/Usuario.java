package com.proyecto.hoja.estilo.proyectoHojaEstilo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import lombok.*;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío.")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres.")
    @Pattern(regexp = "[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+", message = "El nombre solo debe contener letras y espacios")
    @Column(name = "first_name", nullable = false, length = 100)
    private String nombre;

    
    private String apellido;

    @Column(unique = true, nullable = false)
    private String correo;

    private String contrasena;

    private String imagenPerfil;

    private boolean activo = true;

    @Enumerated(EnumType.STRING)
    private Rol rol; // ADMIN, PROFESOR, ALUMNO
}
