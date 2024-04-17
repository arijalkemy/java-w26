package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {



    Map<Integer, List<Prenda>> guardaRopas = new HashMap<>();
    int contador = 1;

    public Integer guardarPrendas(List<Prenda> listDePrendas){
        guardaRopas.put(++this.contador, listDePrendas);
        return this.contador;
    }


    public void mostrarPrendas(){
        System.out.println("Prendas en el locker");
        for (Map.Entry<Integer, List<Prenda>> mapa : this.guardaRopas.entrySet()){
            Integer identificador = mapa.getKey();
            List<Prenda> prendas = mapa.getValue();

            System.out.println("Identificador: " + identificador);
            System.out.println("Prendas:\n ");
            for (Prenda prenda: prendas) {
                System.out.println(prenda.toString());
            }
        }

    }

    public List<Prenda> devolverPrendas(Integer identificador){
        return this.guardaRopas.get(identificador);


    }


}
