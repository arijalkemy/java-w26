package org.savetheropa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> diccionario;
    private int contador;

    public GuardaRopa() {
        this.diccionario = new HashMap<>();
        this.contador = 0;
    }

    public void guardarPrendas(List<Prenda> listaDePrenda) {
        diccionario.put(contador, listaDePrenda);
        contador++;
    }
    //Se guarda una lista en lugar de a una prenda para que se puedan devolver de una vez todas las prendas del
    //mismo usuario

    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> entry : diccionario.entrySet()) {
            System.out.println("Prendas con número identificador " + entry.getKey() + ":");
            for (Prenda prenda : entry.getValue()) {
                System.out.println("Marca: " + prenda.getMarca() + ", Modelo: " + prenda.getModelo());
            }
            System.out.println();
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        if (!diccionario.containsKey(numero)) {
            System.out.println("El número identificador " + numero + " no corresponde a ninguna prenda guardada.");
            return null;
        }
        return diccionario.get(numero);
    }
}
