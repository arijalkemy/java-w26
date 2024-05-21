package com.example.consultashql.service.Impl;

import com.example.consultashql.dto.ResponsePatenteAndMarcaDTO;
import com.example.consultashql.entity.Vehiculo;
import com.example.consultashql.repository.IVehiculoRepository;
import com.example.consultashql.service.IVehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class VehiculoServiceImp implements IVehiculoService {
    private final IVehiculoRepository vehiculoRepository;

    @Override
    public Vehiculo save(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public List<Vehiculo> getAll() {
        return vehiculoRepository.findAll();
    }

    @Override
    public List<String> getPatente() {
        return vehiculoRepository.getPatente();
    }

    @Override
    public List<ResponsePatenteAndMarcaDTO> getPatenteAndMarca() {
        return vehiculoRepository.getPatenteAndMarca().stream().map(x-> new ResponsePatenteAndMarcaDTO(x.getMarca(),x.getPatente())).toList();
    }
}
