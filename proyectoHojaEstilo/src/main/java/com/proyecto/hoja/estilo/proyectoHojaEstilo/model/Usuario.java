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

    @NotBlank(message = "El apellido no puede estar vacío.")
    @Pattern(regexp = "[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+", message = "El apellido solo debe contener letras y espacios")
    @Column(name = "last_name", nullable = false, length = 100)
    private String apellido;

    @Column(unique = true, nullable = false)
    private String correo;

    @NotBlank(message = "La contraseña no puede estar vacía.")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).{8,}$", message = "La contraseña debe incluir al menos una mayúscula, una minúscula, un número y un símbolo")
    @Column(name = "password_hash", nullable = false, length = 255)
    private String contrasena;

    @NotBlank(message = "La URL de la imagen no puede estar vacía.")
    @Size(max = 255, message = "La URL de la imagen no debe superar los 255 caracteres.")
    @Column(nullable = false, length = 255, name = "image_url")
    private String imagenPerfil;

    private boolean activo = true;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 200)
    private Rol rol = Rol.ALUMNO; // ADMIN, PROFESOR, ALUMNO
}
