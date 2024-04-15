package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Guardarropa {
    private Map<Integer, List<Prenda>> prendas = new HashMap<Integer, List<Prenda>>();
    private int contador;

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        this.contador = prendas.size()+1;
        prendas.put(this.contador,listaDePrenda);
        return this.contador;
    }

    public void mostrarPrendas(){
        /*for (Map.Entry<Integer, List<Prenda>> entry : prendas.entrySet()) {
            System.out.println("El guardarropa " + entry.getKey() + " tiene las siguientes prendas: ");
            for(Prenda prenda : entry.getValue()) {
                System.out.println(prenda +"\n");
            }
        }*/
        for (Map.Entry<Integer, List<Prenda>> entry : prendas.entrySet()) {
            System.out.println("El guardarropa " + entry.getKey() + " tiene las siguientes prendas "+ entry.getValue());
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return prendas.get(numero);
    }


}
