package org.example.covid.repository;

import org.example.covid.model.PersonaSintomaDTO;
import org.example.covid.model.SintomaDTO;

import java.util.ArrayList;
import java.util.List;

public class RepositorioGeneral {

    private List<PersonaSintomaDTO> listaPersonaSintomaDTO = new ArrayList<>();
    private List<SintomaDTO> listaSintomaDTO = new ArrayList<>();

    public RepositorioGeneral() {
        cargarListaPersonaSintomaDTO();
        cargarListaSintomaDTO();
    }


    public void cargarListaPersonaSintomaDTO() {
        listaPersonaSintomaDTO = new ArrayList<>();
        listaPersonaSintomaDTO.add(new PersonaSintomaDTO("1", "Camila", "Beczkowski", 60, List.of("dolor de cabeza", "fiebre")));
        listaPersonaSintomaDTO.add(new PersonaSintomaDTO("2", "Celeste", "Beczkowski", 58, List.of("gastroenteritis")));
        listaPersonaSintomaDTO.add(new PersonaSintomaDTO("2", "Luciana", "Beczkowski", 61, new ArrayList<>()));
    }

    public void cargarListaSintomaDTO() {
        listaSintomaDTO = new ArrayList<>();
        listaSintomaDTO.add(new SintomaDTO("1", "Fiebre", 3));
        listaSintomaDTO.add(new SintomaDTO("2", "Dolor de cabeza", 2));
        listaSintomaDTO.add(new SintomaDTO("3", "Gastroenteritis", 4));
    }

    public List<PersonaSintomaDTO> traerListaPersonaSintomaDTO() {
        return listaPersonaSintomaDTO;
    }

    public List<SintomaDTO> traerListaSintomaDTO() {
        return listaSintomaDTO;
    }



}
