package org.example.tiendadeprendas.service;

import org.example.tiendadeprendas.dto.PrendaDto;
import org.example.tiendadeprendas.dto.VentaDto;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    void createVenta(VentaDto ventaDto);
    VentaDto findByIdVenta(String idVenta);
    void updateVenta(String idVenta, VentaDto ventaDto);
    void deleteVenta(String code);
    List<VentaDto> allVentas();
    List<PrendaDto> findAllPrendasByVenta(String idVenta);
    List<PrendaDto> findAllPrendasByFecha(LocalDate fecha);
}
