package com.example.ejercicio_arquitectura_multicapa_p2_vivo_calculadora_de_calorias.entity;

import java.util.List;

public class Plato {
    private String name;
    private List<String> ingredientes;

    public Plato(String name, List<String> ingredientes) {
        this.name = name;
        this.ingredientes = ingredientes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
