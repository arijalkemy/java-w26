package com.example.covid19.services;

import com.example.covid19.dto.PersonaDTO;
import com.example.covid19.models.Persona;
import com.example.covid19.models.Sintoma;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CovidServicesImpl implements ICovidServices{
    private List<Sintoma> listaSintomas = new ArrayList<>();
    private List<Persona> listaPersonas = new ArrayList<>();

    CovidServicesImpl(){
        listaSintomas.add(new Sintoma(1,"fiebre","Alto"));
        listaSintomas.add(new Sintoma(2,"tos","Medio"));
        listaSintomas.add(new Sintoma(3,"dolor de cabeza","Bajo"));

        listaPersonas.add(new Persona(1,"Emiliano","Corv",65, listaSintomas.get(1)));
        listaPersonas.add(new Persona(4,"Maximiliano","Corven",20, listaSintomas.get(2)));
        listaPersonas.add(new Persona(2,"Luis","Perez",54,listaSintomas.get(2)));
        listaPersonas.add(new Persona(3,"Juan","Gonzalez",73,listaSintomas.get(0)));
    }

    @Override
    public List<Sintoma> listarSintomas() {
        return listaSintomas;
    }

    @Override
    public String consultarSintoma(String nombreSintoma) {
        for(Sintoma sintoma : listaSintomas){
            if(sintoma.getNombre().equals(nombreSintoma)){
                return sintoma.getNivel_de_gravedad();
            }
        }
        return null;
    }

    @Override
    public List<PersonaDTO> buscarPersonasDeRiesgo() {
        return listaPersonas.stream()
                            .filter(p -> p.getEdad() > 60)
                            .map(p-> new PersonaDTO(p.getNombre(),p.getApellido())).collect(Collectors.toList());
    }
}
