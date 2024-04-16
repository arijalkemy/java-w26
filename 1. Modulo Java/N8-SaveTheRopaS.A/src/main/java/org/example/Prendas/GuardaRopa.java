package org.example.Prendas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> prendas;

    private Integer id;

    public GuardaRopa() {
        this.prendas = new HashMap<>();
        this.id = 0;
    }

    public Integer guardaPrendas(List<Prenda> listaDePrenda) {
        this.id = id + 1;
        this.prendas.put(id, listaDePrenda);
        return this.id;
    }

    public void mostrarPrendas(){
        this.prendas.forEach((key, value) -> System.out.println("Las prendas son: " + value.toString()));
    }

    public List<Prenda> devolverPrenda(Integer numero){
        return this.prendas.get(numero);
    }


    public Map<Integer, List<Prenda>> getPrendas() {
        return prendas;
    }

    public void setPrendas(Map<Integer, List<Prenda>> prendas) {
        this.prendas = prendas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
