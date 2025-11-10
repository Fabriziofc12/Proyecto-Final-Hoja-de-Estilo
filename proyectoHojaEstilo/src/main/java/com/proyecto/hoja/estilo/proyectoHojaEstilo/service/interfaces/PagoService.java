package com.proyecto.hoja.estilo.proyectoHojaEstilo.service.interfaces;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Pago;
import java.util.List;
import java.util.Optional;


public interface PagoService {
    List<Pago> listarPagos();
    Optional<Pago> obtenerPorId(Long id);
    Pago guardarPago(Pago pago);
    Pago actualizarPago(Long id, Pago pago);
    void eliminarPago(Long id);
}
