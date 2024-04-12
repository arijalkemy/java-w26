package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Repositorio {
    private HashMap<Integer, List<Localizador>> historial;

    public Repositorio() {
        this.historial = new HashMap<>();
    }

    public HashMap<Integer, List<Localizador>> getHistorial() {
        return historial;
    }

    public void setHistorial(HashMap<Integer, List<Localizador>> historial) {
        this.historial = historial;
    }

    public void agregarLocalizador(Localizador localizador) {
        List<Localizador> localizadores = historial.get(localizador.getCliente().getDni());
        if (localizadores == null) {
            List<Localizador> localizadorList = new ArrayList<>();
            localizadorList.add(localizador);
            historial.put(localizador.getCliente().getDni(), localizadorList);
        } else {
            if( localizadores.size() >= 2){
                localizador.setCostoTotal(localizador.getCostoTotal() - localizador.getCostoTotal() * 0.05);
            }

            localizadores.add(localizador);
            historial.put(localizador.getCliente().getDni(),localizadores);
        }
    }
}
