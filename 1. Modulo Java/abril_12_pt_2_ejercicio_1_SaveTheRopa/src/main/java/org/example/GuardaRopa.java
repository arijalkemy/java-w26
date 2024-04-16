package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer , List<Prenda>> ropa = new HashMap<>();
    private static int id = 0;

    private static int key = 0;

    public GuardaRopa(){
        id++;
    }

    public Integer guardarPrendas(List<Prenda> listaPrendas){
        key++;
        ropa.put(key, listaPrendas);
        return key;
    }

    public void mostrarPrendas(){
        for(Map.Entry<Integer, List<Prenda>> entry : ropa.entrySet()){
            System.out.println(entry.getKey()+": ");
            printPrendasList(entry.getValue());
        }
    }

    public void printPrendasList(List<Prenda> prendas){
        for(Prenda prenda : prendas){
            System.out.println(prenda.toString());
        }
    }

    private List<Prenda> devolverPrendas(Integer index){
        return ropa.get(index);
    }

    public List<Prenda> mostrarPrendasByIndex(Integer index){
        List <Prenda> prendas = null;
        if (ropa.containsKey(index)){
                prendas = ropa.get(index);
        }
        return prendas;
    }

}
