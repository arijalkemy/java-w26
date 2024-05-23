package org.example.ejercicios_extra_bd_relacional.service;

import org.example.ejercicios_extra_bd_relacional.dto.VentaDto;
import org.example.ejercicios_extra_bd_relacional.dto.VentaRequestDto;

import java.util.List;

public interface IVentaService {
    VentaDto crearVenta(VentaRequestDto ventaRequestDto);
    List<VentaDto> buscarTodasLasVentas();
    VentaDto buscarVentaPorId(Long id);
}
