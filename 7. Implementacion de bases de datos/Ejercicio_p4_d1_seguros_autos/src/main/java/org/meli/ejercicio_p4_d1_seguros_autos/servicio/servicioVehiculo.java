package org.meli.ejercicio_p4_d1_seguros_autos.servicio;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.meli.ejercicio_p4_d1_seguros_autos.dto.*;
import org.meli.ejercicio_p4_d1_seguros_autos.modelo.Siniestro;
import org.meli.ejercicio_p4_d1_seguros_autos.modelo.Vehiculo;
import org.meli.ejercicio_p4_d1_seguros_autos.modelo.proyeccion.VehiculoConSiniestrosProjection;
import org.meli.ejercicio_p4_d1_seguros_autos.modelo.proyeccion.VehiculoPatentenMarca;
import org.meli.ejercicio_p4_d1_seguros_autos.repositorio.IrepositorioSiniestro;
import org.meli.ejercicio_p4_d1_seguros_autos.repositorio.IrepositorioVehiculo;
import org.meli.ejercicio_p4_d1_seguros_autos.servicio.IService.IServiceVehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class servicioVehiculo implements IServiceVehiculo {
    @Autowired
    private IrepositorioVehiculo repositorioVehiculo;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private IrepositorioSiniestro repositorioSiniestro;;

    @Override
    @Transactional
    public List<VehiculoPatenteDto> listarPatentesVehiculos() {
        List<String> patentes = repositorioVehiculo.listarLasPatentes();
        List<VehiculoPatenteDto> patentesdto =
                patentes.stream()
                .map(v -> objectMapper.convertValue(v, VehiculoPatenteDto.class))
                .collect(Collectors.toList());
        return patentesdto;
    }

    @Override
    @Transactional
    public List<VehiculoPatenteMarcaDto> listarPatentesMarcasVehiculos() {
        List<VehiculoPatenteMarcaDto>  vehiculoPatenteMarcaDto =
                repositorioVehiculo.listarLasPatentesMarcas()
                .stream()
                .map(v -> objectMapper.convertValue(v, VehiculoPatenteMarcaDto.class))
                .collect(Collectors.toList());
        return vehiculoPatenteMarcaDto;
    }

    @Override
    @Transactional
    public List<VehiculoPatenteDto> filtrarVehiculosPorRuedasAgno() {
        List<VehiculoPatenteDto> patentesdto = repositorioVehiculo.listarLasPatentesFilRuedasAgno(3, 1999)
                .stream()
                .map(v -> objectMapper.convertValue(v, VehiculoPatenteDto.class))
                .collect(Collectors.toList());
        return patentesdto;
    }

    @Override
    @Transactional
    public List<VehiculoMMMDto> listarVehiculosMMMsinDetallePerdida(){
        return repositorioSiniestro.listarLosVehicuSinDetallePerdida()
                .stream()
                .map(v -> objectMapper.convertValue(v, VehiculoMMMDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<VehiculoDetallePerdida> listarVehiculosDetallePerdidas(){
        return repositorioSiniestro.listarLosVehicuConDetallePerdida()
                .stream()
                .map(v -> objectMapper.convertValue(v, VehiculoDetallePerdida.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<VehiculoDTO> listarTodosVehiculos() {
        return repositorioVehiculo.listarVehiculosConSiniestros()
                .stream()
                .map(v -> objectMapper.convertValue(v, VehiculoDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    @Transactional
    public VehiculoDTO listarPorIdVehiculos(Long id) {
        List<VehiculoConSiniestrosProjection> list = repositorioVehiculo.listarVehiculosPorId(id);
        VehiculoConSiniestrosProjection vehiculo = list.get(0);
        VehiculoDTO vehiculoDTO = new VehiculoDTO();
        vehiculoDTO.setSiniestros(new HashSet<>());
        list.forEach(
                v -> v.getSiniestros().stream()
                        .forEach(s -> vehiculoDTO.getSiniestros()
                                .add(objectMapper.convertValue(s, SiniestroDTO.class)))
        );
        vehiculoDTO.setPatente(vehiculo.getPatente());
        vehiculoDTO.setAgno_fabricacion(vehiculo.getAgnoFabricacion());
        vehiculoDTO.setModelo(vehiculo.getModelo());
        vehiculoDTO.setMarca(vehiculo.getMarca());
        vehiculoDTO.setMatricula(vehiculo.getMatricula());
        vehiculoDTO.setNumRuedas(vehiculo.getNumRuedas());
        return vehiculoDTO;
    }

    @Override
    @Transactional
    public MensajeDTO nuevoVehiculo(VehiculoDtoRequest vehiculoDTO) {
        Vehiculo vehiculo = objectMapper.convertValue(vehiculoDTO, Vehiculo.class);
        repositorioVehiculo.save(vehiculo);
        vehiculo.getSiniestros().stream().forEach(s ->{
                s.setVehiculo(vehiculo);
                repositorioSiniestro.save(s);
                }
        );
        MensajeDTO mensajeDTO = new MensajeDTO("Creado con exito...");
        return mensajeDTO;
    }
}
