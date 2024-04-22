package org.saveTheRopa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> prendas;
    private Integer contador;

    public GuardaRopa() {
        this.prendas = new HashMap<>();
        this.contador = 0;
    }

    public Integer guardarPrendas(List<Prenda> prendas) {
        this.prendas.put(this.contador, prendas);
        int indice = this.contador;
        this.contador++;
        return indice;
    }

    public void mostrarPrendas() {
        for(Map.Entry<Integer, List<Prenda>> prendasDelIndice: this.prendas.entrySet()) {
            System.out.println(prendasDelIndice.getKey() + ": " + prendasDelIndice);
        }
    }

    public List<Prenda> devolverPrendas(Integer indice) {
        List<Prenda> prendasADevolver = null;
        if(this.prendas.containsKey(indice)) {
            prendasADevolver = this.prendas.get(indice);
        }
        return prendasADevolver;
    }
}
