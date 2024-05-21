package org.ejercicio.hqlvehiculos.service;

import org.ejercicio.hqlvehiculos.DTO.VehiculoDTO;
import org.ejercicio.hqlvehiculos.DTO.VehiculoRequestDTO;
import org.ejercicio.hqlvehiculos.DTO.VehiculosPerdidaTotalDTO;
import org.ejercicio.hqlvehiculos.model.Vehiculo;
import org.ejercicio.hqlvehiculos.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService implements IVehiculoService {

    private final ModelMapper mapper;
    private final IVehiculoRepository vehiculoRepository;

    public VehiculoService(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public VehiculoDTO agregarVehiculo(VehiculoRequestDTO vehiculo) {
        Vehiculo newVehiculo = converRequestDTOtoModel(vehiculo);
        newVehiculo = vehiculoRepository.save(newVehiculo);
        return convertModelToDTO(newVehiculo);
    }

    @Override
    public List<VehiculoDTO> obtenerTodosVehiculos() {
        List<Vehiculo> vehiculos = vehiculoRepository.findAll();
        return vehiculos.stream().map(this::convertModelToDTO).toList();
    }

    @Override
    public List<VehiculoDTO> obtenerVehiculoOrdenadoPorAnioDeFabricacion() {
        List<Vehiculo> vehiculos = vehiculoRepository.findByFechaFabricacion();
        return vehiculos.stream().map(this::convertModelToDTO).toList();
    }

    @Override
    public List<VehiculoDTO> obtenerVehiculoFabricadosEnElAnioActualConRuedasSuperioresA() {
        List<Vehiculo> vehiculos = vehiculoRepository.findByCantidadDeRuedasAndYear();
        return vehiculos.stream().map(this::convertModelToDTO).toList();
    }

    @Override
    public List<VehiculoDTO> obtenerVehiculoSiniestroMayorADiezMil() {
        return mapper.map(vehiculoRepository.findBySinietro10000(), new TypeToken<List<VehiculoDTO>>() {}.getType());
    }

    @Override
    public VehiculosPerdidaTotalDTO obtenerVehiculoSiniestroMayorADiezMilYTotal() {
        List<Vehiculo> vehiculos = vehiculoRepository.findBySinietro10000();
        Double total = vehiculos.stream().map(v -> v.getSiniestros()).mapToDouble(
                sl -> sl.stream().mapToDouble(s -> s.getPerdidaEconomica()).sum()
        ).sum();
        List<VehiculoDTO> vehiculoDTOs = vehiculos.stream().map(this::convertModelToDTO).toList();
        return new VehiculosPerdidaTotalDTO(vehiculoDTOs, total);
    }


    private Vehiculo convertDTOtoModel(VehiculoDTO vehiculo){
        return mapper.map(vehiculo, Vehiculo.class);
    }
    private Vehiculo converRequestDTOtoModel(VehiculoRequestDTO vehiculo){
        return mapper.map(vehiculo, Vehiculo.class);
    }

    private VehiculoDTO convertModelToDTO(Vehiculo vehiculo){
        return mapper.map(vehiculo, VehiculoDTO.class);
    }
}
