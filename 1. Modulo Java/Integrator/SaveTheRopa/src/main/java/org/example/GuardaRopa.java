package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> listaPrendas;

    public GuardaRopa() {
        this.listaPrendas = new HashMap<>();
    }

    public Map<Integer, List<Prenda>> getListaPrendas() {
        return listaPrendas;
    }

    public void setListaPrendas(Map<Integer, List<Prenda>> listaPrendas) {
        this.listaPrendas = listaPrendas;
    }

    public void guardarPrendas(int key, List<Prenda> listaDePrendas){
        for (Map.Entry<Integer, List<Prenda>> entry: listaPrendas.entrySet()) {
            if(entry.getKey() == key){
                throw new Error("Ese espacio del guardaropa ya esta lleno");
            }
        }
        listaPrendas.put(key,listaDePrendas);
        System.out.println("Sus prendas quedaron guardadas en el puesto: " + key);
    }

    public void mostrarPrendas(){
        System.out.println("============GUARDAROPA============");
        for (Map.Entry<Integer, List<Prenda>> entry: listaPrendas.entrySet()){
            System.out.println("Identificador: " + entry.getKey() + ", Prendas: " + entry.getValue());
        }
        System.out.println("==================================");
    }

    public void devolverPrendas(int indentificador){
        listaPrendas.remove(indentificador);
        System.out.println("Sus prendas han sido devueltas");
    }
}
