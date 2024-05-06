package com.example._6_persona_practicatestyvalidaciones.repository;

import com.example._6_persona_practicatestyvalidaciones.model.Deporte;
import com.example._6_persona_practicatestyvalidaciones.utils.JSONUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeporteRepository implements IDeporteRepository{
    private final List<Deporte> deporteList;
    private static final String FILE_NAME = "deporte.json";

    public DeporteRepository() {
        System.out.println(new ClassPathResource(FILE_NAME).getPath());
        this.deporteList = JSONUtils.loadListFromFile(FILE_NAME, Deporte.class);
    }

    @Override
    public Deporte save(Deporte deporte) {
        deporteList.add(deporte);
        JSONUtils.saveListToFile(FILE_NAME, deporteList);
        return deporte;
    }
}
