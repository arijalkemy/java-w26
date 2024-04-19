package com.example.concesionariaautos.service;

import com.example.concesionariaautos.dto.AutoDTO;
import com.example.concesionariaautos.model.Auto;
import com.example.concesionariaautos.repository.AutoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceAutoImpl implements ServiceAuto{

    @Autowired
    AutoRepository autoRepository;

    @Override
    public List<AutoDTO> getAllAutos() {
        List<Auto> autoListAux = autoRepository.getAllAutos();

        return autoListAux.stream().map(auto -> new AutoDTO(auto.getBrand(), auto.getModel(), auto.getManufacturingDate(),
            auto.getNumberOfKm(), auto.getDoors(), auto.getPrice(), auto.getCurrency(), auto.getCountOfOwners()
        )).toList();

    }

    @Override
    public void addAuto(Auto auto) {
        autoRepository.addAuto(auto);
    }

    @Override
    public List<Auto> getCarsByDate(String since, String to) {

        List<Auto> autoListAux = autoRepository.getAllAutos();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate sinceLocalDate =  LocalDate.parse(since, formatter);
        LocalDate toLocalDate =  LocalDate.parse(to, formatter);


        return autoListAux.stream()
                .filter(auto -> auto.getLocalDate(formatter).isAfter(sinceLocalDate)
                        &&(auto.getLocalDate(formatter).isBefore(toLocalDate))).toList();


    }

    @Override
    public List<Auto> getAutoInRangePrice(Integer since, Integer to) {
        List<Auto> autoListAux = autoRepository.getAllAutos();
        return autoListAux.stream().filter(auto -> auto.getPrice() >= since && auto.getPrice() <= to).collect(Collectors.toList());
    }

    @Override
    public Auto getSpecificCar(Integer id) {
        List<Auto> autoListAux = autoRepository.getAllAutos();
        Optional<Auto> posibleCar =  autoListAux.stream().filter(auto -> auto.getId().equals(id)).findFirst();
        if (!posibleCar.isPresent()) {
            return null;
        }

        return posibleCar.get();
    }
}
