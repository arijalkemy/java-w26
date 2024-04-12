package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    Integer indice;
    Map<Integer, List<Prenda>> mapDePrendas;

    public GuardaRopa() {
        this.indice = 0;
        this.mapDePrendas = new HashMap<Integer, List<Prenda>>();
    }

    public Integer guardarPrendas(List<Prenda> prendas){
        this.indice += 1;
        this.mapDePrendas.put(this.indice, prendas);
        return this.indice;
    }

    public void mostrarPrendas(){
        this.mapDePrendas.forEach((i,lista) -> {
            lista.forEach((prenda -> {
                System.out.println("Posicion " + i + " -> " +prenda.toString());
            }));
        });
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return this.mapDePrendas.remove(numero);
    }

}
