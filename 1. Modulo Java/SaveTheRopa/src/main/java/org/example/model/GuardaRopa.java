package org.example.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> diccionario;
    private int contador;

    public GuardaRopa(Map<Integer, List<Prenda>> diccionario, int contador) {
        this.diccionario = diccionario;
        this.contador = contador;
    }

    public GuardaRopa() {
        this.diccionario = new HashMap<>();
        this.contador = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas) {
        diccionario.put(contador, listaDePrendas);
        return contador++;
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> entry : diccionario.entrySet()) {

            List<Prenda> prendas = entry.getValue();
            for (Prenda prenda : prendas) {
                System.out.println("Identificador: " + entry.getKey());
                System.out.println("Marca: " + prenda.getMarca() + "\nModelo: " + prenda.getModelo());
            }
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return diccionario.get(numero);
    }
}
