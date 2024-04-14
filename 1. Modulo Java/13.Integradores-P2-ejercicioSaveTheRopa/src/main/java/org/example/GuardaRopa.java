package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> inventarioPrendas;
    private int contador;

    public GuardaRopa() {
        this.inventarioPrendas = new HashMap<>();
        this.contador = 1;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        this.inventarioPrendas.put(contador,listaDePrenda);
        return contador++;
    }

    public void mostrarPrendas(){
        for(Map.Entry<Integer, List<Prenda>> entry : inventarioPrendas.entrySet()){
            int id = entry.getKey();
            List<Prenda> prendas = entry.getValue();
            System.out.println("Prendas con el id: "+ id);
            System.out.println(prendas.toString());

        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return this.inventarioPrendas.get(numero);
    }

}
