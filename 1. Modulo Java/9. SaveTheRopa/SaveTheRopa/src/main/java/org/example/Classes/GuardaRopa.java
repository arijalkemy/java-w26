package org.example.Classes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> mapPrendas;
    private int id;

    public GuardaRopa() {
        this.mapPrendas = new HashMap<Integer,List<Prenda>>();
        this.id = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaPrendas) {
        Integer idStorage = this.id++;
        mapPrendas.put(id, listaPrendas);
        return idStorage;
    }

    public void MostrarPrendas(){
        for (Map.Entry<Integer, List<Prenda>> entry : mapPrendas.entrySet()) {
            int key = entry.getKey();
            List<Prenda> value = entry.getValue();
            System.out.println("Numero: " + key);
            System.out.println("Prendas: ");
            for (Prenda element : value) {
                System.out.println(element + "\n");
                System.out.println("_____________________");
            }
        }
    }
    public List<Prenda> devolverPrendas(Integer numero){
        List<Prenda> value = null;
        for (Map.Entry<Integer, List<Prenda>> entry : mapPrendas.entrySet()) {
            int key = entry.getKey();
            if (key == numero){
                value = entry.getValue();
            }
        }
        return value;
    }
}
