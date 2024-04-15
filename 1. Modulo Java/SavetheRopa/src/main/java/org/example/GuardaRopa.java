package org.example;

import java.util.HashMap;

public class GuardaRopa {
    HashMap<Integer, Prenda[]> prendas;
    int contador = 1;

    public GuardaRopa(){
        prendas = new HashMap<>();
    }

    public Integer guardarPrendas(Prenda[] listaDePrenda) {
        prendas.put(contador, listaDePrenda);
        return contador++;
    }

    public void mostrarPrendas() {
        prendas.forEach((k, v) -> {
            System.out.println("Prendas guardadas en el identificador: " + k);
            for (Prenda prenda : v) {
                System.out.println("Marca: " + prenda.getMarca() + " Modelo: " + prenda.getModelo());
            }
        });
    }


}
