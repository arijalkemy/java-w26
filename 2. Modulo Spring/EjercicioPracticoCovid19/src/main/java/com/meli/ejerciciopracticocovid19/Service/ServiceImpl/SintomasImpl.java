package com.meli.ejerciciopracticocovid19.Service.ServiceImpl;

import com.meli.ejerciciopracticocovid19.DTO.PersonaDTO;
import com.meli.ejerciciopracticocovid19.DTO.SintomaDTO;
import com.meli.ejerciciopracticocovid19.Modelo.ObjectList;
import com.meli.ejerciciopracticocovid19.Service.ISintomas;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SintomasImpl implements ISintomas {

    @Override
    public List<PersonaDTO> listaPersonas() {
        return ObjectList.personasList.stream().filter(persona -> persona.getEdad() >= 60 && persona.getSintomas().size() > 1).toList();
    }


    @Override
    public List<SintomaDTO> listaSintomas() {
        return ObjectList.sintomasList;
    }


    @Override
    public SintomaDTO sintoma(String nombre) throws Exception {
        Optional<SintomaDTO> sintoma = ObjectList.sintomasList.stream()
                .filter(s -> s.getNombre().equalsIgnoreCase(nombre))
                .findFirst();
        if (sintoma.isPresent()) {
            return sintoma.get();
        } else {
            throw new Exception("No existe este síntoma: " + nombre);
        }
    }
}
