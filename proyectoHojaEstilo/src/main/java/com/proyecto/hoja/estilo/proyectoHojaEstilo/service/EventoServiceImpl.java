package com.proyecto.hoja.estilo.proyectoHojaEstilo.service;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Evento;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.repository.EventoRepository;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.service.interfaces.EventoService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoServiceImpl implements EventoService {

    private final EventoRepository eventoRepository;

    public EventoServiceImpl(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    @Override
    public List<Evento> listarEventos() {
        return eventoRepository.findAll();
    }

    @Override
    public Optional<Evento> obtenerPorId(Long id) {
        return eventoRepository.findById(id);
    }

    @Override
    public Evento guardarEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    @Override
    public Evento actualizarEvento(Long id, Evento evento) {
        return eventoRepository.findById(id)
            .map(e -> {
                e.setNombre(evento.getNombre());
                e.setDescripcion(evento.getDescripcion());
                e.setFechaHora(evento.getFechaHora());
                return eventoRepository.save(e);
            })
            .orElseThrow(() -> new RuntimeException("Evento no encontrado"));
    }

    @Override
    public void eliminarEvento(Long id) {
        eventoRepository.deleteById(id);
    }
}