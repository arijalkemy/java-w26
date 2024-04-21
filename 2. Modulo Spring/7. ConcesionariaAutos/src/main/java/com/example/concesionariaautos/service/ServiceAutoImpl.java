package com.example.concesionariaautos.service;

import com.example.concesionariaautos.dto.AutoDTO;
import com.example.concesionariaautos.model.Auto;
import com.example.concesionariaautos.repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
    public List<Auto> getCarsByPrice(String since, String to) {
        List<Auto> autoListAux = autoRepository.getAllAutos();
        return autoListAux.stream()
                .filter(auto ->
                        auto.getPrice() > Integer.parseInt(since) && auto.getPrice() < Integer.parseInt(to) )
                .toList();
    }

    @Override
    public List<Auto> getCarById(String id) {
        List<Auto> autoListAux = autoRepository.getAllAutos();
        return autoListAux.stream().filter(auto -> auto.getId().equals(Integer.parseInt(id))).toList();
    }


}
