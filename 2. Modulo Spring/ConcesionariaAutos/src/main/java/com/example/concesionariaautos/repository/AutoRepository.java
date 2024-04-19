package com.example.concesionariaautos.repository;

import com.example.concesionariaautos.dto.AutoDTO;
import com.example.concesionariaautos.model.Auto;
import com.example.concesionariaautos.model.Service;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AutoRepository {

    private List<Auto> autoList = new ArrayList<>();

    public void addAuto(Auto auto) {

        autoList.add(auto);
    }


    public List<Auto> getAllAutos() {
        return autoList;
    }





}
