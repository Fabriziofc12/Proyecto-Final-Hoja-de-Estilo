package com.proyecto.hoja.estilo.proyectoHojaEstilo.service;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Evento;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Profesor;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.repository.CursoRepository;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.repository.EventoRepository;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.repository.ProfesorRepository;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.service.interfaces.EventoService;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.service.interfaces.ProfesorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    private final ProfesorRepository profesorRepository;

    @Autowired
    public ProfesorServiceImpl(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    @Override
    public List<Profesor> listarProfesores() {
        return profesorRepository.findAll();
    }

    @Override
    public Optional<Profesor> obtenerPorId(Long id) {
        return profesorRepository.findById(id);
    }

    @Override
    public Profesor guardarProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    @Override
    public Profesor actualizarProfesor(Long id, Profesor profesorActualizado) {
        return profesorRepository.findById(id)
                .map(profesor -> {
                    profesor.setNombre(profesorActualizado.getNombre());
                    profesor.setApellido(profesorActualizado.getApellido());
                    profesor.setEspecialidad(profesorActualizado.getEspecialidad());
                    profesor.setNacionalidad(profesorActualizado.getNacionalidad());
                    profesor.setDescripcion(profesorActualizado.getDescripcion());
                    profesor.setImagenPerfil(profesorActualizado.getImagenPerfil());
                    return profesorRepository.save(profesor);
                })
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado con ID: " + id));
    }

    @Override
    public void eliminarProfesor(Long id) {
        profesorRepository.deleteById(id);
    }
}