package org.example.tiendadeprendas.service;

import org.example.tiendadeprendas.dto.PrendaDto;
import org.example.tiendadeprendas.dto.VentaDto;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    void createVenta(VentaDto ventaDto);
    VentaDto findByIdVenta(Long idVenta);
    void updateVenta(Long idVenta, VentaDto ventaDto);
    void deleteVenta(Long code);
    List<VentaDto> allVentas();
    List<PrendaDto> findAllPrendasByVenta(Long idVenta);
    List<PrendaDto> findAllPrendasByFecha(LocalDate fecha);
}
