package meli.bootcamp.SaveTheRopa.entidades;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> mapPrendas;
    private Integer contador;

    public GuardaRopa() {
        this.mapPrendas = new HashMap<>();
        this.contador = 0;
    }

    @Override
    public String toString() {
        return "GuardaRopa{" + "mapPrendas=" + mapPrendas + ", contador=" + contador + '}';
    }

    public Integer guardarPrendas(List<Prenda> prendas) {
        this.mapPrendas.put(++this.contador, prendas);
        return contador;
    }

    public void mostrarPrendas() {
        for(Map.Entry<Integer, List<Prenda>> entry : this.mapPrendas.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return this.mapPrendas.get(numero);
    }
}
