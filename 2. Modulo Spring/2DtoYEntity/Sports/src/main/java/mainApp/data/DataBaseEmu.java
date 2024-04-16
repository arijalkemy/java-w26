package mainApp.data;

import model.PersonDTO;
import model.SportDTO;

import java.util.ArrayList;
import java.util.List;

public class DataBaseEmu {

    public List<PersonDTO> listaPersonas = new ArrayList<>();
    public List<SportDTO> listaSports = new ArrayList<>();

    public void populate(){


        listaSports.add(new SportDTO("futbolamericano", 2));
        listaSports.add(new SportDTO("futbolsoccer", 1));
        listaSports.add(new SportDTO("box", 3));

        listaPersonas.add(new PersonDTO("mau", "garcia", 30, listaSports));
        listaPersonas.add(new PersonDTO("juan", "ramirez", 20, listaSports));
        listaPersonas.add(new PersonDTO("alberto", "perez", 10, listaSports));
        listaPersonas.add(new PersonDTO("daniela", "sanchez", 35, listaSports));
    }


}
