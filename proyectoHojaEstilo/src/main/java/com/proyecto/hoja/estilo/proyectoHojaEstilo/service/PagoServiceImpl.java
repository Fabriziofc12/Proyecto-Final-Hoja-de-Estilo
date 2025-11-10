package com.proyecto.hoja.estilo.proyectoHojaEstilo.service;

import com.proyecto.hoja.estilo.proyectoHojaEstilo.model.Pago;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.repository.PagoRepository;
import com.proyecto.hoja.estilo.proyectoHojaEstilo.service.interfaces.PagoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoServiceImpl implements PagoService {

    private final PagoRepository pagoRepository;

    public PagoServiceImpl(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    @Override
    public List<Pago> listarPagos() {
        return pagoRepository.findAll();
    }

    @Override
    public Optional<Pago> obtenerPorId(Long id) {
        return pagoRepository.findById(id);
    }

    @Override
    public Pago guardarPago(Pago pago) {
        // Si quieres agregar validaciones, puedes hacerlo aquí
        return pagoRepository.save(pago);
    }

    @Override
    public Pago actualizarPago(Long id, Pago pagoActualizado) {
        return pagoRepository.findById(id)
                .map(pago -> {
                    pago.setUsuario(pagoActualizado.getUsuario());
                    pago.setMonto(pagoActualizado.getMonto());
                    pago.setFechaPago(pagoActualizado.getFechaPago());
                    pago.setMetodoPago(pagoActualizado.getMetodoPago());
                    pago.setReferencia(pagoActualizado.getReferencia());
                    return pagoRepository.save(pago);
                })
                .orElseThrow(() -> new RuntimeException("Pago no encontrado con ID: " + id));
    }

    @Override
    public void eliminarPago(Long id) {
        pagoRepository.deleteById(id);
    }
}