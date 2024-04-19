package com.example.multicapatemplate.service.impl;

import com.example.multicapatemplate.dto.VehiculoDto;
import com.example.multicapatemplate.model.Vehiculo;
import com.example.multicapatemplate.repository.impl.ConcesionariaRepository;
import com.example.multicapatemplate.service.IConcesionariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConcesionariaServiceImpl implements IConcesionariaService {

    @Autowired
    ConcesionariaRepository repositoryTemplate;

    @Override
    public List<VehiculoDto> getAll() {
        List<Vehiculo> vehiculos = repositoryTemplate.getAll();
        return vehiculos.stream().map(VehiculoDto::new).collect(Collectors.toList());
    }

    @Override
    public void save(Vehiculo vehiculo) {
        repositoryTemplate.save(vehiculo);
    }

    @Override
    public List<VehiculoDto> getAll(LocalDate fechaDesde, LocalDate fechaHasta) {
        return repositoryTemplate.getAll().stream().filter( v -> v.getFecha().isAfter( fechaDesde ) && v.getFecha().isBefore( fechaHasta ) ).map(VehiculoDto::new).toList();
    }

    @Override
    public List<VehiculoDto> getAll(double precioDesde, double precioHasta) {
        return repositoryTemplate.getAll().stream().filter( v -> v.getPrecio() >= precioDesde && v.getPrecio() < precioHasta ).map(VehiculoDto::new).toList();
    }

    @Override
    public VehiculoDto getVehiculoByPlaca(String placa) {
        Optional<Vehiculo> vehiculo = repositoryTemplate.getAll().stream().filter(x -> x.getPlaca().equals(placa)).findFirst();

        if( vehiculo.isPresent()  ){
            return new VehiculoDto(vehiculo.get());
        }
        return null;
    }
}
