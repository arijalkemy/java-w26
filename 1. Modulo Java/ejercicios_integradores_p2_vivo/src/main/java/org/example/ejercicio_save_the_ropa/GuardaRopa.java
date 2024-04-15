package org.example.ejercicio_save_the_ropa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GuardaRopa {
    private Integer identificador;
    private Map<Integer, List<Prenda>> contenido = new HashMap<>();

    public GuardaRopa() {
        identificador = 0;
    }

    public Integer guardarPrendas(List<Prenda> prendas) {
        identificador++;
        contenido.put(identificador, prendas);
        return identificador;
    }

    public void mostrarPrendas() {
        for(Map.Entry<Integer, List<Prenda>> entry : contenido.entrySet()) {
            Integer key = entry.getKey();
            List<Prenda> prendas = entry.getValue();
            System.out.println("Prendas en la posición " + key + ": ");
            for (Prenda prenda : prendas) {
                System.out.println("- " + prenda.toString());
            }
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return contenido.entrySet().stream()
                .filter(entry -> entry.getKey() == numero)
                .map(Map.Entry::getValue)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
