package org.example.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Integer id = 0;
    private Map<Integer,List<Prenda>> prendas;

    public GuardaRopa() {
        this.id = 0;
        this.prendas = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        this.id++;
        prendas.put(this.id, listaDePrenda);
        return this.id;
    }

    public void mostrarPrendas(){
        for (Map.Entry<Integer, List<Prenda>> entry : prendas.entrySet()) {
            List<Prenda> listaGuardada = entry.getValue();
            for(Prenda prenda : listaGuardada){
                System.out.println(prenda.toString());
            }
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return this.prendas.get(numero);
    }
}
