package com.meli.ejerciciopracticocovid19.Service;

import com.meli.ejerciciopracticocovid19.DTO.PersonaDTO;
import com.meli.ejerciciopracticocovid19.DTO.SintomaDTO;
import com.meli.ejerciciopracticocovid19.Repository.Sintoma;

import java.util.List;

public interface ISintomas {

    public List<SintomaDTO> listaSintomas();
    public List<PersonaDTO> listaPersonas();
    public SintomaDTO sintoma(String nombre) throws Exception;
}
