package org.example;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    private List<Localizador> localizadores = new ArrayList<>();

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    public boolean agregarLocalizador(Localizador localizador){
        this.localizadores.add(localizador);
        return verificarReservasMismoCliente();
    }

    public boolean verificarReservasMismoCliente() {
        boolean descuentoFuturo = false;
        //hacer con lambda
        for(int i=0; i<localizadores.size(); i++) {
            Cliente cliente = localizadores.get(i).getCliente();
            for (int j = 0; j < localizadores.size(); j++) {
                if (cliente.equals(localizadores.get(j).getCliente())) {
                    descuentoFuturo = true;
                }
            }
        }
        return descuentoFuturo;
    }

    @Override
    public String toString() {
        return "Repositorio{" +
                "localizadores=" + localizadores +
                '}';
    }
}
