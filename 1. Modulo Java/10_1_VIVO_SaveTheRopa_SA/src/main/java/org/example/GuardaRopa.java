package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> diccionario;
    private Integer contador;

    public GuardaRopa() {
        this.diccionario = new HashMap<>();
        this.contador = 0;
    }

    public Map<Integer, List<Prenda>> getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(Map<Integer, List<Prenda>> diccionario) {
        this.diccionario = diccionario;
    }

    public Integer getIdentifier() {
        return contador;
    }

    public void setIdentifier(Integer identifier) {
        this.contador = identifier;
    }
    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        diccionario.put(contador++,listaDePrenda);
        return contador;
    }
    public void mostrarPrendas(){
        diccionario.forEach((K,V) -> System.out.println(K + "  "+V));
    }
    public List<Prenda> devolverPrendas(Integer numero){
        return diccionario.remove(numero);
    }
}
