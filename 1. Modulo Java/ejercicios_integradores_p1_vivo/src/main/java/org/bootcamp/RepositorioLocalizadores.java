package org.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class RepositorioLocalizadores {
    private List<Localizador> localizadores;

    public RepositorioLocalizadores() {
        this.localizadores = new ArrayList<>();
    }


    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    public void agregarLocalizador(Localizador localizador) {
        if(localizador.getCliente().getTieneDescuentoCincoPorCiento()) {
            localizador.setTotal(localizador.getTotal() * 0.95);
            this.localizadores.add(localizador);
        } else {
            this.localizadores.add(localizador);
            int contador = 0;

            for (Localizador loc : localizadores) {
                if (loc.getCliente().equals(localizador.getCliente())) {
                    contador++;
                    if(contador == 2) {
                        localizador.getCliente().setTieneDescuentoCincoPorCiento(true);
                        break;
                    }
                }
            }
        }

        System.out.println(localizador);
    }

    @Override
    public String toString() {
        return "RepositorioLocalizadores{" +
                "localizadores=" + localizadores +
                '}';
    }
}
