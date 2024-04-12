package org.meli.clases;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> diccionarioPrendas;
    private Integer identificador = 0;

    public GuardaRopa() {
        diccionarioPrendas = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        identificador++;
        diccionarioPrendas.put(identificador, listaDePrenda);
        return identificador;
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> entry : diccionarioPrendas.entrySet()) {
            System.out.println("Identificador: " + entry.getKey());
            for (Prenda prenda : entry.getValue()) {
                System.out.println("Marca: " + prenda.getMarca() + " Modelo: " + prenda.getModelo());
            }
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        List<Prenda> prendas = diccionarioPrendas.get(numero);
        diccionarioPrendas.remove(numero);
        return prendas;
    }
}
