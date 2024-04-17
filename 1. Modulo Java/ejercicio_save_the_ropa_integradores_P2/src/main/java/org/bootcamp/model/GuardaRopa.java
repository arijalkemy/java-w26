package org.bootcamp.model;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GuardaRopa {
    private Integer contador = 0;
    private Map<Integer, List<Prenda>> guardaRopas;

    public GuardaRopa() {
        this.guardaRopas = new TreeMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        guardaRopas.put(++contador, listaDePrenda);
        return contador;
    }

    public void mostrarPrendas(){
        System.out.println("\n---- Prendas en el Guarda Ropa ----");
        guardaRopas.forEach(
                (clave, valor) -> System.out.println("\nNúmero identificador: " + clave + "\nLista de Prendas: " + valor));
    }

    public List<Prenda> devolverPrenda(Integer numero){
        List<Prenda> prendasADevolver = guardaRopas.get(numero);

        if(prendasADevolver != null && !prendasADevolver.isEmpty())
            guardaRopas.remove(numero);

        return prendasADevolver;
    }

}
