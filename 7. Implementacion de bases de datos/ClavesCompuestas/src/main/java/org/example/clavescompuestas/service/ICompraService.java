package org.example.clavescompuestas.service;

import org.example.clavescompuestas.dto.CompraDTO;

import java.util.List;

public interface ICompraService {
    CompraDTO save(CompraDTO compra);
    List<CompraDTO> getAllCompras();
}
