package org.example.ejercicios_extra_elasticsearch.service;

import org.example.ejercicios_extra_elasticsearch.dto.VentaDto;
import org.example.ejercicios_extra_elasticsearch.dto.VentaRequestDto;

import java.util.List;

public interface IVentaService {
    VentaDto crearVenta(VentaRequestDto ventaRequestDto);
    List<VentaDto> buscarTodasLasVentas();
    VentaDto buscarVentaPorId(String id);
}
