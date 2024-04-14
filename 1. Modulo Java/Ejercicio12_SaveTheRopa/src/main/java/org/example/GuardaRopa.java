package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    public Map<Integer, List<Prenda>> prendas = new HashMap<>();
    public int identificador = 0;

    public Integer guardarPrendas(List<Prenda> listaDePrendas) {
        identificador++;
        prendas.put(identificador, listaDePrendas);
        return identificador;
    }

    public void mostrarPrendas() {
        if (prendas.isEmpty()) {
            System.out.println("No hay prendas guardadas en este momento ");
        }
        {
            for (Map.Entry<Integer, List<Prenda>> prendas : prendas.entrySet()) {
                System.out.println("Código: " + prendas.getKey());
                for (Prenda prenda : prendas.getValue()) {
                    System.out.println("\t" + prenda.toString());
                }
            }
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        if (prendas.containsKey(numero)) {
            return prendas.remove(numero);
        }
        System.out.println("No existen prendas asociadas a dicho ID");
        return null;
    }

}
