package com.spring.deportistas.services;

import com.spring.deportistas.models.Sport;

import java.util.List;

public interface ISportsService {

    List<Sport> getAllSports();

    Sport getSportByName(String name);

}
