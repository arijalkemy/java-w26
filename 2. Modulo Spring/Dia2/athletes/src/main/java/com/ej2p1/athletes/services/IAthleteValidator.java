package com.ej2p1.athletes.services;

import com.ej2p1.athletes.dto.SportPersonDTO;

import java.util.List;

public interface IAthleteValidator {
    List<SportPersonDTO> findAthletes();
}
