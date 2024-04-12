package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> prendas = new HashMap<>();

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        prendas.put(prendas.size(), listaDePrenda);
        return prendas.size() - 1;
    }

    public void mostrarPrendas(){
        prendas.forEach((k, v) -> {
            System.out.println("Prendas en la posición " + k + ":");
            v.forEach(prenda -> System.out.println("Marca: " + prenda.getMarca() + " Modelo: " + prenda.getModelo()));
        });
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return prendas.get(numero);
    }
}
