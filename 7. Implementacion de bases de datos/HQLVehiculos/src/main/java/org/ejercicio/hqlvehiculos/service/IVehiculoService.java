package org.ejercicio.hqlvehiculos.service;

import org.ejercicio.hqlvehiculos.DTO.VehiculoDTO;
import org.ejercicio.hqlvehiculos.DTO.VehiculoRequestDTO;
import org.ejercicio.hqlvehiculos.DTO.VehiculosPerdidaTotalDTO;

import java.util.List;

public interface IVehiculoService {
    VehiculoDTO agregarVehiculo(VehiculoRequestDTO vehiculo);
    List<VehiculoDTO> obtenerTodosVehiculos();
    List<VehiculoDTO> obtenerVehiculoOrdenadoPorAnioDeFabricacion();
    List<VehiculoDTO> obtenerVehiculoFabricadosEnElAnioActualConRuedasSuperioresA();
    List<VehiculoDTO> obtenerVehiculoSiniestroMayorADiezMil();
    VehiculosPerdidaTotalDTO obtenerVehiculoSiniestroMayorADiezMilYTotal();
}
