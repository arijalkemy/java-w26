package com.asinc_ejerciciocovid19.servicio;

import com.asinc_ejerciciocovid19.dto.PersonaSintomaDTO;

import java.util.List;

public interface IPersonaServicio {
    List<PersonaSintomaDTO> obtenerPersonasDeRiesgo();
}
