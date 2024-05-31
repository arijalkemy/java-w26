package com.Ejercicio.Deportistas.Service;

import com.Ejercicio.Deportistas.DTO.SportDTO;
import com.Ejercicio.Deportistas.Entity.Sport;
import com.Ejercicio.Deportistas.Exception.NotFoundException;
import com.Ejercicio.Deportistas.Repository.ISportRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SportServiceImpl implements ISportService {

    ISportRepository iSportRepository;
    ModelMapper modelMapper;

    public SportServiceImpl(ISportRepository iSportRepository) {
        this.iSportRepository = iSportRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<SportDTO> findAllSports() {
        List<Sport> sportList = iSportRepository.findAllSports();
        List<SportDTO> sportDTOList = sportList.stream()
                .map(sport -> modelMapper.map(sport, SportDTO.class))
                .collect(Collectors.toList());
        return sportDTOList;
    }

    @Override
    public String findSportBy(String name) {
        List<Sport> sportList = iSportRepository.findAllSports();
        Sport sportByName = sportList
                .stream()
                .filter(sport -> sport.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Sport not found"));
        return sportByName.getLevel();
    }
}
