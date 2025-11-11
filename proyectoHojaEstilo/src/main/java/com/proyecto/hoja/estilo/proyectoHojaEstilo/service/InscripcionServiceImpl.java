package com.proyecto.hoja.estilo.proyectoHojaEstilo.service;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Inscripcion;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.repository.InscripcionRepository;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.service.interfaces.InscripcionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InscripcionServiceImpl implements InscripcionService {

    private final InscripcionRepository inscripcionRepository;

    public InscripcionServiceImpl(InscripcionRepository inscripcionRepository) {
        this.inscripcionRepository = inscripcionRepository;
    }

    @Override
    public List<Inscripcion> listarInscripciones() {
        return inscripcionRepository.findAll();
    }

    @Override
    public Optional<Inscripcion> obtenerPorId(Long id) {
        return inscripcionRepository.findById(id);
    }

    @Override
    public Inscripcion guardarInscripcion(Inscripcion inscripcion) {
        // Si la fecha no está definida, la asignamos automáticamente
        if (inscripcion.getFechaInscripcion() == null) {
            inscripcion.setFechaInscripcion(LocalDateTime.now());
        }
        return inscripcionRepository.save(inscripcion);
    }

    @Override
    public Inscripcion actualizarInscripcion(Long id, Inscripcion inscripcionActualizada) {
        return inscripcionRepository.findById(id)
                .map(inscripcionExistente -> {
                    inscripcionExistente.setAlumno(inscripcionActualizada.getAlumno());
                    inscripcionExistente.setCurso(inscripcionActualizada.getCurso());
                    inscripcionExistente.setFechaInscripcion(
                            inscripcionActualizada.getFechaInscripcion() != null
                                    ? inscripcionActualizada.getFechaInscripcion()
                                    : inscripcionExistente.getFechaInscripcion()
                    );
                    inscripcionExistente.setEstado(inscripcionActualizada.getEstado());
                    return inscripcionRepository.save(inscripcionExistente);
                })
                .orElseThrow(() -> new IllegalArgumentException("Inscripción no encontrada con ID: " + id));
    }

    @Override
    public void eliminarInscripcion(Long id) {
        if (!inscripcionRepository.existsById(id)) {
            throw new IllegalArgumentException("La inscripción con ID " + id + " no existe.");
        }
        inscripcionRepository.deleteById(id);
    }

    @Override
    public List<Inscripcion> listarPorUsuario(Long alumno) {
        return inscripcionRepository.findByAlumno_id(alumno);
    }

    @Override
    public List<Inscripcion> listarPorCurso(Long cursoId) {
        return inscripcionRepository.findByCursoId(cursoId);
    }
}
