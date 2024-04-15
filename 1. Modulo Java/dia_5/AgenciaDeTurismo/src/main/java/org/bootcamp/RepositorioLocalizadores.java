package org.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class RepositorioLocalizadores {
    private List<Localizador> localizadores;

    public RepositorioLocalizadores() {
        this.localizadores = new ArrayList<Localizador>();
    }

    public RepositorioLocalizadores(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    public void agregarLocalizador(Localizador localizador) {
        int contador = 0;
        for (Localizador loc : localizadores) {
            if (loc.getCliente().equals(localizador.getCliente())) contador++;
        }
        if (contador >= 2) localizador.aplicarDescuento();
        this.localizadores.add(localizador);

    }

    @Override
    public String toString() {
        return "RepositorioLocalizadores{" +
                "localizadores=" + localizadores +
                '}';
    }
}
