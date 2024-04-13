package org.example;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> prendas = new Hashtable<>();
    private int contadorId = 0;

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        contadorId++;
        prendas.put(contadorId, listaDePrenda);
        return contadorId;
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> listaDePrendas : prendas.entrySet()) {
            System.out.println(listaDePrendas.getKey());
            System.out.println(listaDePrendas.getValue());
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return prendas.get(numero);
    }


}
