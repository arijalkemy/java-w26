package org.example;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> diccionario = new HashMap<>();
    private int contador = 0;

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        int id = contador++;
        diccionario.put(id, listaDePrenda);
        return id;
    }

    public void mostrarPrendas() {
        diccionario.forEach((id, prendas) -> {
            System.out.println("Identificador " + id + ":");
            prendas.forEach(prenda -> System.out.println(prenda));
        });
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return diccionario.remove(numero);
    }
}
