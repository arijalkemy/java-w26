package org.example;

import java.util.List;

public class RepositoryLocalizador {

    private List<Localizador> localizadorList;

    public void agregarLocalizador(Localizador localizador) {
        if (!localizadorList.contains(localizador)) {
            localizadorList.add(localizador);
        }
    }
    public boolean localizadorTieneCliente(Localizador localizador, Cliente cliente) {
        for (Localizador l : localizadorList) {
            if (l.equals(localizador)) {
                for (Reserva r : l.getReservas()) {
                    if (r.getCliente().equals(cliente)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public List<Localizador> getLocalizadorList() {
        return localizadorList;
    }

    public RepositoryLocalizador setLocalizadorList(List<Localizador> localizadorList) {
        this.localizadorList = localizadorList;
        return this;
    }
}
