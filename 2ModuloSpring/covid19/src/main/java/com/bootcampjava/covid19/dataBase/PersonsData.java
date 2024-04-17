package com.bootcampjava.covid19.dataBase;

import com.bootcampjava.covid19.model.Persona;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class PersonsData {
    public PersonsData() {
        cargarBaseDeDatos(20);
    }

    private List<Persona> dbPersonas = new ArrayList<Persona>();

    /**
     * ccarga una base de dtao de ejemplo
     * @param cantidad numero entero que define la longitud d ela base de datos ejemplo : 15
     */
    public void cargarBaseDeDatos(int cantidad){
        for (int i = 0; i < cantidad; i++) {
            dbPersonas.add(new Persona(i + 1, generarNombrerandom(), generarApellidoRandom(), generarEdadRandom()));
        }
    }
    // Helper methods to generate random person attributes
    private static String generarNombrerandom() {
        String[] names = {"Alice", "Bob", "Charlie", "David", "Emily", "Frank", "Grace", "Harry", "Isabella", "Jack"};
        return names[(int) (Math.random() * names.length)];
    }

    private static String generarApellidoRandom() {
        String[] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Taylor", "Martin", "Anderson"};
        return lastNames[(int) (Math.random() * lastNames.length)];
    }

    private static int generarEdadRandom() {
        return (int) (Math.random() * 60) + 18;
    }
}
