package com.javabootcamp.consesionarioautos.service;

import com.javabootcamp.consesionarioautos.dto.AutoDTO;
import com.javabootcamp.consesionarioautos.model.Auto;
import com.javabootcamp.consesionarioautos.repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class AutoService {

    @Autowired
    AutoRepository autoRepository;

    public boolean saveNewAuto(Auto auto) throws FileNotFoundException {
        try{
            autoRepository.saveNewAuto(auto);
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public List<AutoDTO> getALlAutos(){
        return mapAutoToDTO(autoRepository.getFoodList());
    }

    public AutoDTO getAutoById(int id){
        Optional<Auto> autoID = autoRepository.getFoodList().stream().filter(a->a.getId()==id).findFirst();
        if(autoID.isPresent()){
            AutoDTO foundAuto = new AutoDTO(
                    autoID.get().getId(),
                    autoID.get().getBrand(),
                    autoID.get().getModel(),
                    autoID.get().getManufacturingDate(),
                    autoID.get().getNumberOfKilometers(),
                    autoID.get().getDoors(),
                    autoID.get().getPrice(),
                    autoID.get().getCurrency(),
                    autoID.get().getCountOfOwners()
            );
            return foundAuto;
        }
        else return null;
    }

    public Optional<Auto> findAutoById(int i){
        return autoRepository.getFoodList().stream().filter(a->a.getId()==i).findFirst();
    }

    public List<AutoDTO> orderByDate(){
        Comparator<Auto> autoDateComparator = Comparator.comparing(obj-> LocalDate.parse(obj.getManufacturingDate(),
                DateTimeFormatter.ISO_DATE));
        return mapAutoToDTO(autoRepository.getFoodList().stream().sorted(autoDateComparator).toList());
    }

    public List<AutoDTO> orderByPrice(){
        Comparator<Auto> autoPriceComparator = Comparator.comparingInt(obj->Integer.parseInt(obj.getPrice()));
        return mapAutoToDTO(autoRepository.getFoodList().stream().sorted(autoPriceComparator).toList());
    }

    private List<AutoDTO> mapAutoToDTO(List<Auto> autos){
        List<AutoDTO> allAutoDto = new ArrayList<>();
        autos.forEach(auto -> allAutoDto.add(new AutoDTO(
                auto.getId(),
                auto.getBrand(),
                auto.getModel(),
                auto.getManufacturingDate(),
                auto.getNumberOfKilometers(),
                auto.getDoors(),
                auto.getPrice(),
                auto.getCurrency(),
                auto.getCountOfOwners()
        )));
        return allAutoDto;
    }

}
