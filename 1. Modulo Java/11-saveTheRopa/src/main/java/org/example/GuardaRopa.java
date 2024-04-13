package org.example;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private int cont;
    private HashMap<Integer, List<Prenda>> mapPrendas;

    public GuardaRopa() {
        this.cont = 0;
        this.mapPrendas = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        cont++;
        mapPrendas.put(cont, listaDePrenda);
        return cont;
    }

    public void mostrarPrendas() {
        mapPrendas.forEach((k, v) -> {
            v.forEach( p -> {
                System.out.println("Codigo: " + k + " "+ p.toString());
            });
        });

    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return mapPrendas.get(numero);
    }

}
