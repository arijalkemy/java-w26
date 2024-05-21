package com.example.sinisestros.service.impl;

import com.example.sinisestros.dto.ListPatentesDTO;
import com.example.sinisestros.dto.ListPatentesyMarcasDTO;
import com.example.sinisestros.repository.IVehiculoRepository;
import com.example.sinisestros.service.IVehiculoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

    private final IVehiculoRepository vehiculoRepository;

    public VehiculoServiceImpl (IVehiculoRepository vehiculoRepository){
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public ListPatentesDTO getAllPatentes(){
        return new ListPatentesDTO(vehiculoRepository.getAllPatentes());
    }

    @Override
    public ListPatentesyMarcasDTO getAllPatentesYMarcas(){
        return new ListPatentesyMarcasDTO(vehiculoRepository.getAllPatentesYMarcas());
    }

    @Override
    public ListPatentesDTO getPatentesMasDeCuatroRuedasAnioActual(){
        return new ListPatentesDTO(vehiculoRepository.getPatentesMasDeCuatroRuedasAnioActual());
    }
}
