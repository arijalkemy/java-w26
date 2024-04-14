package org.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    Map<Integer,List<Prenda>> mapPrendas;
    private int contador = 0;

    public GuardaRopa() {
        this.mapPrendas = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        mapPrendas.put(contador+1,listaDePrenda);
        return listaDePrenda.size()+1;
    }

    public void mostrarPrendas(){
        mapPrendas.forEach((k,v)-> {
            System.out.println("Id guardaropa: "+k);
            for(Prenda prenda:v){
                System.out.println(prenda.toString()+"\n");
            }
        });
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return mapPrendas.get(numero);
    }
}
