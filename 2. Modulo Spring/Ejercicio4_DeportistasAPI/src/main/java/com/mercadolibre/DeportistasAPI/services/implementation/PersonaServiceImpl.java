package com.mercadolibre.DeportistasAPI.services.implementation;

import com.mercadolibre.DeportistasAPI.DTO.PersonaDTO;
import com.mercadolibre.DeportistasAPI.model.Persona;
import com.mercadolibre.DeportistasAPI.repository.RepoBD;
import com.mercadolibre.DeportistasAPI.services.IPersonaService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService {
    //Logica donde se obtiene la lista de personas deportistas
    @Override
    public List<PersonaDTO> visualizarDeportistas() {
        List<PersonaDTO> deportistas = new ArrayList<>();
        for (Persona p : RepoBD.personas){
            deportistas.add(new PersonaDTO(p.getNombre()+" "+p.getApellido(), p.getDeporte().getNombre()));
        }
        return deportistas;
    }
}
