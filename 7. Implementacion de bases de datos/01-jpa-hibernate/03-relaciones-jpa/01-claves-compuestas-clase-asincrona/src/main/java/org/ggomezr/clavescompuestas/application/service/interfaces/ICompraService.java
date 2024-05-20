package org.ggomezr.clavescompuestas.application.service.interfaces;

import org.ggomezr.clavescompuestas.domain.dto.CompraDTO;

import java.util.List;

public interface ICompraService {
    CompraDTO crearCompra(CompraDTO compraDTO);
    List<CompraDTO> obtenerTodasLasCompras();
}
