package com.meli.ejercicioenvivovehiculo.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.meli.ejercicioenvivovehiculo.dto.VehiculeDTO;
import com.meli.ejercicioenvivovehiculo.exception.VehiculeExist;
import com.meli.ejercicioenvivovehiculo.exception.VehiculeNotFound;
import com.meli.ejercicioenvivovehiculo.model.Vehicule;
import com.meli.ejercicioenvivovehiculo.repository.Impl.VehiculeRepository;
import com.meli.ejercicioenvivovehiculo.service.IVehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meli.ejercicioenvivovehiculo.exception.VehiculeExist;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class VehiculeImpl implements IVehiculeService {

    @Autowired
    private VehiculeRepository vehiculeRepository;

    @Override
    public VehiculeDTO getVehicule(int id) {
        ObjectMapper mapper = new ObjectMapper();
        Vehicule vehicule = vehiculeRepository.findById(id);
        if(vehicule == null){
            throw new VehiculeNotFound("El vehiculo con id " +id + " no ha sido encontrado" );
        }
        return mapper.convertValue(vehicule, VehiculeDTO.class);

    }

    @Override
    public List<VehiculeDTO> getVehicules() {
        ObjectMapper mapper = new ObjectMapper();
        return vehiculeRepository.getVehicules().stream().
                map(x -> mapper.convertValue(x,VehiculeDTO.class)).toList();
    }

    @Override
    public List<VehiculeDTO> getVehiculeByManufactureDate(LocalDate dateInitial, LocalDate dateFinal) {
        ObjectMapper objectMapper = new ObjectMapper();
        return vehiculeRepository.findByDateCreation(dateInitial,dateFinal).stream().map(x -> objectMapper.convertValue(x, VehiculeDTO.class)).toList();
    }

    @Override
    public List<VehiculeDTO> getVehiculeByPrice(int since, int to) {
        ObjectMapper objectMapper = new ObjectMapper();
        return vehiculeRepository.findByPrice(since,to).stream().map(x -> objectMapper.convertValue(x,VehiculeDTO.class)).toList();
    }

    @Override
    public VehiculeDTO createVehicule(VehiculeDTO vehiculeDTO)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        Vehicule vehicle = vehiculeRepository.findById(vehiculeDTO.getId());
        if (vehicle == null) {
            throw new VehiculeExist("El vehículo con ID: " + vehiculeDTO.getId() + " ya existe");
        }
        vehiculeRepository.addVehicule(objectMapper.convertValue(vehiculeDTO, Vehicule.class));
        return vehiculeDTO;

    }
}
