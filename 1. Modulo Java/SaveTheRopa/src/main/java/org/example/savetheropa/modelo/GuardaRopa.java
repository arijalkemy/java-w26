package org.example.savetheropa.modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> guardaRopa;
    private Integer contador;

    public GuardaRopa() {
        this.guardaRopa = new HashMap<Integer, List<Prenda>>();
        this.contador = 1;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas) {
        guardaRopa.put(contador, listaDePrendas);
        contador++;
        return contador-1;
    }
    public void mostrarPrendas() {
        this.guardaRopa.entrySet().forEach(e -> {
            System.out.println("\n\nId: " + e.getKey());
            System.out.println("\nPrendas: \n");
            e.getValue().forEach(System.out::println);
        });
    }
    public List<Prenda> devolverPrendas(Integer numero) {
        List<Prenda> prendas = guardaRopa.get(numero);
        return prendas;
    }

}
