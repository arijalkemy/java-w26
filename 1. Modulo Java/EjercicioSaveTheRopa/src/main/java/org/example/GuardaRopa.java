package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer,List<Prenda>> mapa;
    private int contador;

    public GuardaRopa() {
        this.mapa = new HashMap<>();
        this.contador = 1;
    }

    public Integer guardarPrendas(List<Prenda> prendas) {
        mapa.put(this.contador, prendas);
        this.contador++;
        return this.contador -1;
    }

    public void  mostrarPrendas(){
        for (Map.Entry<Integer, List<Prenda>> entrada : this.mapa.entrySet()) {
            System.out.println("Espacio en guardaropa: "+entrada.getKey());
            for (Prenda prenda : entrada.getValue()) {
                System.out.println(prenda);
            }
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        List<Prenda> prendas=null;
        if(this.mapa.containsKey(numero)){
            prendas=this.mapa.get(numero);
        }
        return prendas;
    }

}
