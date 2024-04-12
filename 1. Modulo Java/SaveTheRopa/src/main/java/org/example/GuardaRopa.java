package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private HashMap<Integer, List<Prenda>> prendaMap = new HashMap<>();
    private int contador = 0;

    public GuardaRopa() {
    }

    public Integer guardarRopa(List<Prenda> prendaList){
        prendaMap.put(contador, prendaList);
        int indice = contador;
        contador++;
        return indice;
    }

    public void mostrarPrendas(){
        for(Map.Entry<Integer, List<Prenda>> orden : prendaMap.entrySet()){
            System.out.println(orden.getKey() + " - " + orden.getValue());
        }
    }

    public List<Prenda> devolverPrenda(Integer indice){
        List<Prenda> ret = prendaMap.get(indice);
        prendaMap.remove(indice);
        return ret;
    }
}
