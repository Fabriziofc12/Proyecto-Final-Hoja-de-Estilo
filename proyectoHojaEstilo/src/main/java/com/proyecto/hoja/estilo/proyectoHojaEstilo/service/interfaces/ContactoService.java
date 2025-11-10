package com.proyecto.hoja.estilo.proyectoHojaEstilo.service.interfaces;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Contacto;
import java.util.List;
import java.util.Optional;


public interface ContactoService {
    List<Contacto> listarMensajes();
    Contacto guardarMensaje(Contacto contacto);
}
