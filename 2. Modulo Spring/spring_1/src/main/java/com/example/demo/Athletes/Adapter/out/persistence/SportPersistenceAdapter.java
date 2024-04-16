package com.example.demo.Athletes.Adapter.out.persistence;

import com.example.demo.Athletes.Application.out.ISportFinds;
import com.example.demo.Athletes.Domain.Sport;
import com.example.demo.Athletes.Domain.erros.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class SportPersistenceAdapter implements ISportFinds {


    List<Sport> sportsList = Arrays.asList(
            new Sport("Soccer", 5),
            new Sport("Basketball", 4),
            new Sport("Tennis", 3),
            new Sport("Swimming", 2),
            new Sport("Cycling", 1)
    );

    @Override
    public List<Sport> findAll() {
        return sportsList;
    }

    @Override
    public Sport findByName(String name) {
        return sportsList.stream()
                .filter(sport -> sport.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Sport", name));
    }
}
