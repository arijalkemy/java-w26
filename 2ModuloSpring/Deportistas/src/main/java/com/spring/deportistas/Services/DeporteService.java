package com.spring.deportistas.Services;

import com.spring.deportistas.Models.Deporte;
import com.spring.deportistas.Repository.MockDB;
import com.spring.deportistas.Services.Interfaces.IDeporteService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeporteService implements IDeporteService {

    @Override
    public List<Deporte> getAllSports() {
        return MockDB.sportsList;
    }

    @Override
    public String findLevelBySportName(String name) {
        Deporte deporte = MockDB.sportsList.stream().filter(d -> d.getNombre().equals(name)).findFirst().orElse(null);
        if(deporte == null) return null;
        return deporte.getNivel();
    }
}
