package org.meli.ejercicio_p4_d1_seguros_autos.servicio.IService;

import org.meli.ejercicio_p4_d1_seguros_autos.dto.*;
import org.meli.ejercicio_p4_d1_seguros_autos.modelo.Vehiculo;
import org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


public interface IServiceVehiculo {
    public List<VehiculoPatenteDto> listarPatentesVehiculos();
    public List<VehiculoPatenteMarcaDto> listarPatentesMarcasVehiculos();
    public List<VehiculoPatenteDto> filtrarVehiculosPorRuedasAgno();
    public List<VehiculoMMMDto> listarVehiculosMMMsinDetallePerdida();
    public List<VehiculoDetallePerdida> listarVehiculosDetallePerdidas();
    public List<VehiculoDTO> listarTodosVehiculos();
    public VehiculoDTO listarPorIdVehiculos(Long id);
    public MensajeDTO nuevoVehiculo(VehiculoDtoRequest vehiculoDTO);
}
