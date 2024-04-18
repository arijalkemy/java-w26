package com.Ejercicio.Deportistas.Service;

import com.Ejercicio.Deportistas.Repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportServiceImpl implements Sport {
    @Override
    public List<Sport> getSports() {
        return SportRepository.sportList;
    }
}
