package org.bootcamp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> mapa;
    private int count;

    public GuardaRopa() {
        this.count = 0;
        this.mapa = new HashMap<>();
    }

    public GuardaRopa(Map<Integer, List<Prenda>> mapa) {
        this.mapa = mapa;
        this.count = 0;
    }

    public Map<Integer, List<Prenda>> getMapa() {
        return mapa;
    }

    public void setMapa(Map<Integer, List<Prenda>> mapa) {
        this.mapa = mapa;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Integer guardarPrendas(List<Prenda> prendas) {
        int numero = count;
        this.mapa.put(numero, prendas);
        count++;
        return numero;
    }

    public void mostrarPrendas() {
        mapa.forEach((k, v) -> System.out.println("Numero: " + k + "Prendas: " + v));
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return mapa.get(numero);
    }
}
