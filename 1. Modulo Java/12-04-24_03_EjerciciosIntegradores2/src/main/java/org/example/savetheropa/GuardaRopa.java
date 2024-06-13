package org.example.savetheropa;

import org.example.savetheropa.Prenda;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> prendas;
    private int contador;

    public GuardaRopa() {
        this.prendas = new HashMap<>();
        this.contador = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        contador++;
        prendas.put(contador, listaDePrenda);
        return contador;
    }

    public void mostrarPrendas() {
        prendas.forEach((key, value) -> {
            System.out.println("Número: " + key);
            value.forEach(prenda -> System.out.println("  " + prenda));
        });
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return prendas.remove(numero);
    }
}
