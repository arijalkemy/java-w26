package org.example.repository;

import org.example.entity.Prenda;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {

    private HashMap<Integer, List<Prenda>> guardaRopa;

    private Integer prendaContador;

    public GuardaRopa() {
        this.guardaRopa = new HashMap<>();
        this.prendaContador = 0;
    }

    public HashMap<Integer, List<Prenda>> getGuardaRopa() {
        return guardaRopa;
    }

    public void setGuardaRopa(HashMap<Integer, List<Prenda>> guardaRopa) {
        this.guardaRopa = guardaRopa;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        this.guardaRopa.put(prendaContador, listaDePrenda);
        return prendaContador++;
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return this.guardaRopa.get(numero);
    }

    @Override
    public String toString() {
        return "GuardaRopa{" + "ID: " + prendaContador + "PRENDAS: " + guardaRopa + '}';
    }

    public void mostrarPrendas() {
        System.out.println(this.guardaRopa);
    }

}
