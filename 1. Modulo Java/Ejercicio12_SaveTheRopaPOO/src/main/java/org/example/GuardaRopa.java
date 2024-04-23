package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private int idPrendas;
    private Map<Integer, List<Prenda>> guardaRopa;

    public GuardaRopa(){
        this.idPrendas = 0;
        this.guardaRopa = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> prendas){
        this.idPrendas++;
        guardaRopa.put(this.idPrendas,prendas);
        return (this.idPrendas);
    }

    public void mostrarPrendas(){
        for (int i = 1; i <= guardaRopa.size(); i++) {
            System.out.println("guarda ropa: prendas # "+i);
            guardaRopa.get(i).stream().forEach(System.out::println);
        }
    }
    public List<Prenda> devolverPrendas(Integer numero){
        return guardaRopa.get(numero);
    }
}
