package org.example;

import java.util.*;

public class GuardaRopa {
    private int contador;
    private Map<Integer, Prenda> ropa = new HashMap<>();

    public GuardaRopa() {
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        int key = 1;
        Random rand = new Random();
        int numeroAleatorio = rand.nextInt(100);
        for (Prenda prenda : listaDePrenda) {
            this.ropa.put(key++, prenda);
        }
        this.contador = numeroAleatorio;
        return this.contador;
    }

    public void mostrarPrendas(){
        System.out.println("Prendas guardadas en el guarda Ropa[" + this.contador + "]:");
        for (Map.Entry<Integer, Prenda> entry : ropa.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }

    public List<Prenda> devolverPrendas(){
        List<Prenda> prendas = new ArrayList<>(this.ropa.values());
        return prendas;
    }
}
