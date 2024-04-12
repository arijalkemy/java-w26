package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GuardaRopa {
    private HashMap<Integer, List<Prenda>> hashPrendas;
    private int contador;

    public GuardaRopa() {
        this.hashPrendas = new HashMap<>();
        this.contador = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        this.contador += 1;
        hashPrendas.put(this.contador, listaDePrenda);
        return this.contador;
    }

    public void mostrarPrendas() {
        this.hashPrendas.forEach(
                (id, p) -> {
                    System.out.println("ID: " + id + "\nPrendas: ");
                    p.forEach(prenda -> System.out.println("- " + prenda.getMarca() + " " + prenda.getModelo()));
                });
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return this.hashPrendas.remove(numero);
    }
}
