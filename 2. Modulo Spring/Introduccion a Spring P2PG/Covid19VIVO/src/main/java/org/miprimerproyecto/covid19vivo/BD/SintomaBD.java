package org.miprimerproyecto.covid19vivo.BD;

import org.miprimerproyecto.covid19vivo.clases.Sintoma;

import java.util.ArrayList;
import java.util.List;

public class SintomaBD {
    public static List<Sintoma> listaSintoma= new ArrayList<Sintoma>();
    static{
        listaSintoma.add(new Sintoma(120, "Fiebre", 4));
        listaSintoma.add(new Sintoma(121, "Tos", 2));
        listaSintoma.add(new Sintoma(122, "Respiracion", 6));
        listaSintoma.add(new Sintoma(123, "Fatiga", 3));
        listaSintoma.add(new Sintoma(124, "DolorCabeza", 4));
    }

    public int getSintomaByName(String name) {
        int nivel=0;
        for (Sintoma sintoma : listaSintoma) {
            if (sintoma.getNombre().equals(name)) {
                nivel=sintoma.getNivelDeGravedad();
                break;
            }
        }
        return nivel;
    }
}
