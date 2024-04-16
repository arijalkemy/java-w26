package main.data;

import main.model.PersonDTO;
import main.model.SintomaDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBase {
    public List<PersonDTO> personList;
    public HashMap<Integer, List<SintomaDTO>> hashSintoms;

    public DataBase(){
         personList = new ArrayList<>();
         hashSintoms = new HashMap<>();
    }

    public void populate(){
        List<SintomaDTO> listaSintomas1 = new ArrayList<>();
        listaSintomas1.add(new SintomaDTO(1, "tos", 4));

        List<SintomaDTO> listaSintomas2 = new ArrayList<>();
        listaSintomas2.add(new SintomaDTO(2, "mocos", 3));
        listaSintomas2.add(new SintomaDTO(3, "fiebre", 2));
        listaSintomas2.add(new SintomaDTO(4, "sueño", 3));

        hashSintoms.put(1, listaSintomas1);
        hashSintoms.put(2, listaSintomas2);

        personList = new ArrayList<>();
        personList.add(new PersonDTO(1, "mau", "garcia", 90));
        personList.add(new PersonDTO(2, "luis", "ramirez", 23));

    }
}
