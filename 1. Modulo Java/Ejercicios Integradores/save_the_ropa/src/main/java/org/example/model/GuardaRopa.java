package org.example.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> listaPrendas = new HashMap<>();
    private int contador = -1;

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        listaPrendas.put(++contador, listaDePrenda);
        return contador;

    }

    public void mostrarPrendas(){
        System.out.println("-------- Impresión de todo el Guarda Ropa -----------");
        for (List<Prenda> prendas : listaPrendas.values()) {
            prendas.forEach(System.out::println);
        }
        System.out.println("-----------------------------------------------------");
    }

    public List<Prenda> devolverPrendas(Integer id){
        return listaPrendas.get(id);
    }




}
