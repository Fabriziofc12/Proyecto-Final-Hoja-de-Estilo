package com.proyecto.hoja.estilo.proyectoHojaEstilo.service.interfaces;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.EventoParticipante;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.repository.EventoParticipanteRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EventoParticipanteServiceImpl implements EventoParticipanteService {

    private final EventoParticipanteRepository eventoParticipanteRepository;

    public EventoParticipanteServiceImpl(EventoParticipanteRepository eventoParticipanteRepository) {
        this.eventoParticipanteRepository = eventoParticipanteRepository;
    }

    @Override
    public List<EventoParticipante> listarTodos() {
        return eventoParticipanteRepository.findAll();
    }

    @Override
    public Optional<EventoParticipante> obtenerPorId(Long id) {
        return eventoParticipanteRepository.findById(id);
    }

    @Override
    public EventoParticipante guardar(EventoParticipante eventoParticipante) {
        return eventoParticipanteRepository.save(eventoParticipante);
    }

    @Override
    public void eliminar(Long id) {
        eventoParticipanteRepository.deleteById(id);
    }

    @Override
    public List<EventoParticipante> obtenerPorEvento(Long eventoId) {
        return eventoParticipanteRepository.findByEventoId(eventoId);
    }

    @Override
    public List<EventoParticipante> obtenerPorUsuario(Long usuarioId) {
        return eventoParticipanteRepository.findByUsuarioId(usuarioId);
    }
}