package org.example.classes;

import java.util.List;

public class RepositorioLocalizador {
    private List<Localizador> localizadores;

    public RepositorioLocalizador(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    public void add(Localizador localizador) {
        localizadores.add(localizador);
    }

    public boolean tiene2Localizadores(int idCliente) {
        List<Localizador> resultado = localizadores
                .stream()
                .filter(localizador -> localizador.getCliente().getId() == idCliente)
                .toList();

        if (resultado.size() >= 2) return true;
        return false;
    }
}
