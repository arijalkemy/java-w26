package com.sinc_ejercicioconcesionaria.servicio.implementacion;

import com.sinc_ejercicioconcesionaria.dto.ServiceVehiculoDTO;
import com.sinc_ejercicioconcesionaria.dto.VehiculoRequestDTO;
import com.sinc_ejercicioconcesionaria.dto.VehiculoResponseDTO;
import com.sinc_ejercicioconcesionaria.entidad.ServiceVehiculo;
import com.sinc_ejercicioconcesionaria.entidad.Vehiculo;
import com.sinc_ejercicioconcesionaria.repositorio.RepositorioVehiculo;
import com.sinc_ejercicioconcesionaria.servicio.IVehiculoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehiculoServicioImplementacion implements IVehiculoServicio {

    @Autowired
    private RepositorioVehiculo repoVehiculo;

    @Override
    public void agregarVehiculo(VehiculoRequestDTO vehiculoDTO) {
        repoVehiculo.agregarVehiculo(convertirVehiculoDTO(vehiculoDTO));
    }

    @Override
    public List<VehiculoResponseDTO> obtenerVehiculosUsados() {
        List<VehiculoResponseDTO> listaVehiculosDTO = new ArrayList<>();
        for (Vehiculo vehiculo : RepositorioVehiculo.listaVehiculos) {
            if (vehiculo.getNumeroKilometros() != 0) { //verifico si es usado
                listaVehiculosDTO.add(convertirVehiculoADTO(vehiculo));
            }
        }
        return listaVehiculosDTO;
    }

    @Override
    public List<VehiculoResponseDTO> obtenerVehiculosPorPeriodos(LocalDate fechaDesde, LocalDate fechaHasta) {
        List<VehiculoResponseDTO> listadoVehiculosDTO = new ArrayList<>();
        for (Vehiculo vehiculo : RepositorioVehiculo.listaVehiculos) {
            if (vehiculo.getFechaFabricacion().isBefore(fechaHasta) &&
                    vehiculo.getFechaFabricacion().isAfter(fechaDesde)) {
                listadoVehiculosDTO.add(convertirVehiculoADTO(vehiculo));
            }
        }
        return listadoVehiculosDTO;
    }

    @Override
    public List<VehiculoResponseDTO> obtenerVehiculosPorRangoPrecio(int precioDesde, int precioHasta) {
        List<VehiculoResponseDTO> listadoVehiculosDTO = new ArrayList<>();
        for (Vehiculo vehiculo : RepositorioVehiculo.listaVehiculos) {
            if ((vehiculo.getPrecio() > precioDesde) && (vehiculo.getPrecio() < precioHasta)) {
                listadoVehiculosDTO.add(convertirVehiculoADTO(vehiculo));
            }
        }
        return listadoVehiculosDTO;
    }

    @Override
    public VehiculoResponseDTO obtenerVehiculoPorModelo(String modelo) {
        Vehiculo vehiculo = RepositorioVehiculo.listaVehiculos.stream()
                            .filter(v -> v.getModelo().equalsIgnoreCase(modelo))
                            .findFirst()
                            .orElse(null);
        if (vehiculo != null) {
            return convertirVehiculoADTO(vehiculo);
        }
        return null;
    }

    private Vehiculo convertirVehiculoDTO(VehiculoRequestDTO vehiculoRequestDTO) {

        return new Vehiculo(vehiculoRequestDTO.getMarca(),
                            vehiculoRequestDTO.getModelo(),
                            vehiculoRequestDTO.getFechaFabricacion(),
                            vehiculoRequestDTO.getNumeroKilometros(),
                            vehiculoRequestDTO.getPuertas(),
                            vehiculoRequestDTO.getPrecio(),
                            vehiculoRequestDTO.getMoneda(),
                            convertirServicesDTO(vehiculoRequestDTO.getServicesDto()),
                            vehiculoRequestDTO.getCantidadDueños());
    }

    private List<ServiceVehiculo> convertirServicesDTO(List<ServiceVehiculoDTO> servicesDTO) {
        List<ServiceVehiculo> serviceVehiculos = new ArrayList<>();

        for (ServiceVehiculoDTO serviceVehiculoDTO : servicesDTO) {
            serviceVehiculos.add(new ServiceVehiculo(serviceVehiculoDTO.getFecha(),
                                                    serviceVehiculoDTO.getKilometros(),
                                                    serviceVehiculoDTO.getDescripcion()));
        }

        return serviceVehiculos;
    }

    private VehiculoResponseDTO convertirVehiculoADTO(Vehiculo vehiculo) {
        return new VehiculoResponseDTO(vehiculo.getMarca(),
                                        vehiculo.getModelo(),
                                        vehiculo.getFechaFabricacion(),
                                        vehiculo.getNumeroKilometros(),
                                        vehiculo.getPuertas(),
                                        vehiculo.getPrecio(),
                                        vehiculo.getMoneda(),
                                        vehiculo.getCantidadDueños());
    }
}
