package com.proyecto.hoja.estilo.proyectoHojaEstilo.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "profesores")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Profesor {

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

    @NotBlank(message = "La especialidad no puede estar vacío.")
    @Pattern(regexp = "[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+", message = "La especialidad solo debe contener letras y espacios")
    @Column(name = "speciality", nullable = false, length = 100)
    private String especialidad;

    @NotBlank(message = "La nacionalidad no puede estar vacío.")
    @Pattern(regexp = "[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+", message = "La nacionalidad solo debe contener letras y espacios")
    @Column(name = "nacionality", nullable = false, length = 100)
    private String nacionalidad;

    @Column(length = 1000)
    private String descripcion;

    private String imagenPerfil;
}

