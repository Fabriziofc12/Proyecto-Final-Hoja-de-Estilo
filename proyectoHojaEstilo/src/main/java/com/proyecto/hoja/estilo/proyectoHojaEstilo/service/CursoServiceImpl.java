package com.proyecto.hoja.estilo.proyectoHojaEstilo.service;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Curso;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.repository.CursoRepository;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.service.interfaces.CursoService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Optional<Curso> obtenerPorId(Long id) {
        return cursoRepository.findById(id);
    }

    @Override
    public Curso guardarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Curso actualizarCurso(Long id, Curso curso) {
        return cursoRepository.findById(id)
            .map(c -> {
                c.setTitulo(curso.getTitulo());
                c.setDescripcion(curso.getDescripcion());
                c.setNivel(curso.getNivel());
                return cursoRepository.save(c);
            })
            .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
    }

    @Override
    public void eliminarCurso(Long id) {
        cursoRepository.deleteById(id);
    }
}