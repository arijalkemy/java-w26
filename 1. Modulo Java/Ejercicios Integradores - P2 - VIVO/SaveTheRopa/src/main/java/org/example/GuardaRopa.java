package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> prendas;
    private static int CONTADOR = 0;

    public GuardaRopa() {
        this.prendas = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        this.prendas.put(++CONTADOR, listaDePrenda);
        return prendas.size();
    }

    public void mostrarPrendas() {
        this.prendas
                .forEach((x, y) -> System.out.printf("Id: %d ; prendas: %s%n", x, y));
    }

    public Optional<List<Prenda>> devolverPrendas(Integer numero) {

        if (this.prendas.containsKey(numero)) {
            return Optional.of(prendas.get(numero));
        }
        return Optional.empty();
    }

}
