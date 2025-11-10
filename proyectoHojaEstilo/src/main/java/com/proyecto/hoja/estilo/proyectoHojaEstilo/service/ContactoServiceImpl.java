package com.proyecto.hoja.estilo.proyectoHojaEstilo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Contacto;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.repository.ContactoRepository;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.service.interfaces.ContactoService;

@Service
public class ContactoServiceImpl implements ContactoService {

    private final ContactoRepository contactoRepository;

    public ContactoServiceImpl(ContactoRepository contactoRepository) {
        this.contactoRepository = contactoRepository;
    }

    @Override
    public List<Contacto> listarMensajes() {
        return contactoRepository.findAll();
    }

    @Override
    public Contacto guardarMensaje(Contacto contacto) {
        return contactoRepository.save(contacto);
    }
}
