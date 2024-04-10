package com.company;

import java.util.HashSet;

public class CarreraDeLaSelva {
    private final HashSet<Participante> participantes;
    private HashSet<Categoria> categorias;

    public CarreraDeLaSelva(HashSet<Categoria> categorias, HashSet<Participante> participantes) {
        this.categorias = categorias;
        this.participantes = participantes;
    }

    public int montoTotal() {
        int montoActual = 0;
        for(Categoria categoria : categorias){
            montoActual += categoria.montoTotal();
        }
        return montoActual;
    }

    public void addCategoria(Categoria categoria){
        this.categorias.add(categoria);
    }

    public void addParticipante(Participante participante){
        this.participantes.add(participante);
    }
}
