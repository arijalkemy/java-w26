package com.sinc_ejercicioconcesionaria.servicio;

import com.sinc_ejercicioconcesionaria.dto.VehiculoRequestDTO;
import com.sinc_ejercicioconcesionaria.dto.VehiculoResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface IVehiculoServicio {
    void agregarVehiculo(VehiculoRequestDTO vehiculoDTO);

    List<VehiculoResponseDTO> obtenerVehiculosUsados();

    List<VehiculoResponseDTO> obtenerVehiculosPorPeriodos(LocalDate fechaDesde, LocalDate fechaHasta);

    List<VehiculoResponseDTO> obtenerVehiculosPorRangoPrecio(int precioDesde, int precioHasta);

    VehiculoResponseDTO obtenerVehiculoPorModelo(String modelo);
}
