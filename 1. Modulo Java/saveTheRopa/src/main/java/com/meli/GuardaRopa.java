package com.meli;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> diccionario;
    private int identificador = 1;

    public GuardaRopa() {
        this.diccionario = new HashMap<>();
    }

    public Map<Integer, List<Prenda>> getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(Map<Integer, List<Prenda>> diccionario) {
        this.diccionario = diccionario;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas) {
        if (listaDePrendas == null || listaDePrendas.isEmpty()) {
            throw new IllegalArgumentException("La lista de prendas no puede estar vacía.");
        }

        int identificadorAuxiliar = identificador;
        this.diccionario.put(identificadorAuxiliar, listaDePrendas);
        this.identificador++;

        return identificadorAuxiliar;
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> entry : this.diccionario.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return this.diccionario.get(numero);
    }
}
