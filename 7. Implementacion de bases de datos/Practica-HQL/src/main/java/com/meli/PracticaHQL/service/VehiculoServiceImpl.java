package com.meli.PracticaHQL.service;

import com.meli.PracticaHQL.dto.PatenteDto;
import com.meli.PracticaHQL.model.Vehiculo;
import com.meli.PracticaHQL.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public List<PatenteDto> getPatentes() {
        List<Vehiculo> vehiculos = (List<Vehiculo>) vehiculoRepository.findAll();
        return vehiculos.stream().map(v -> new PatenteDto(v.getId(), v.getPatente())).toList();
    }

    @Override
    public List<PatenteDto> getPatentesYMarcas() {
        List<Vehiculo> vehiculos = vehiculoRepository.findAllByOrderByAnioDeFabricacion();
        return vehiculos.stream()
                .map(v -> new PatenteDto(v.getId(), v.getPatente(), v.getMarca())).toList();
    }

    @Override
    public List<String> getVehiculosConCuatroRuedas() {
        int anioActual = LocalDate.now().getYear();
        return vehiculoRepository.findAllByCantidadDeRuedasGreaterThanEqualAAndAnioDeFabricacionGreaterThanEqual(4, anioActual)
                .stream().map(Vehiculo::getPatente).toList();
    }

    @Override
    public Vehiculo save(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }
}
