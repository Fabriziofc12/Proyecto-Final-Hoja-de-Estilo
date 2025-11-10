package com.proyecto.hoja.estilo.proyectoHojaEstilo.service;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Clase;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Curso;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.repository.ClaseRepository;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.repository.CursoRepository;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.service.interfaces.ClaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ClaseServiceImpl implements ClaseService {

    private final ClaseRepository claseRepository;
    private final CursoRepository cursoRepository;

    public ClaseServiceImpl(ClaseRepository claseRepository, CursoRepository cursoRepository) {
        this.claseRepository = claseRepository;
        this.cursoRepository = cursoRepository;
    }

    @Override
    public Clase crearClase(Clase clase) {
        Curso curso = cursoRepository.findById(clase.getCurso().getId())
                .orElseThrow(() -> new IllegalArgumentException("El curso asociado no existe"));

        if (clase.getNumeroClase() == null) {
            int cantidadActual = claseRepository.countByCursoId(curso.getId());
            clase.setNumeroClase(cantidadActual + 1);
        }

        clase.setCurso(curso);
        return claseRepository.save(clase);
    }

    @Override
    public Clase actualizarClase(Long id, Clase claseActualizada) {
        Clase claseExistente = claseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Clase no encontrada"));

        claseExistente.setTitulo(claseActualizada.getTitulo());
        claseExistente.setDescripcion(claseActualizada.getDescripcion());
        claseExistente.setVideoUrl(claseActualizada.getVideoUrl());

        return claseRepository.save(claseExistente);
    }

    @Override
    public void eliminarClase(Long id) {
        if (!claseRepository.existsById(id)) {
            throw new IllegalArgumentException("No se puede eliminar, la clase no existe");
        }
        claseRepository.deleteById(id);
    }

    @Override
    public Clase obtenerPorId(Long id) {
        return claseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Clase no encontrada"));
    }

    @Override
    public List<Clase> listarPorCurso(Long cursoId) {
        if (!cursoRepository.existsById(cursoId)) {
            throw new IllegalArgumentException("El curso especificado no existe");
        }
        return claseRepository.findByCursoIdOrderByNumeroClaseAsc(cursoId);
    }
}