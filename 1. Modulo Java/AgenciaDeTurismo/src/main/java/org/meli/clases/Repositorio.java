package org.meli.clases;
import java.util.List;
import java.util.ArrayList;

public class Repositorio {
    List<Localizador> localizadorList;

    public Repositorio() {
        this.localizadorList = new ArrayList<>();
    }

    public void addLocalizador(Localizador localizador) {
        if (contarLocalizadoresPorCliente(localizador.getCliente().getDni()) > 2)
            localizador.agregarDescuento(0.05);
        localizador.aplicarDescuento();
        this.localizadorList.add(localizador);
    }

    public float contarLocalizadoresPorCliente(Integer dni) {
        return this.localizadorList.stream().filter(l -> l.getCliente().getDni().equals(dni)).count();
    }

    @Override
    public String toString() {
        String localizadores = "";
        for (Localizador localizador : localizadorList) {
            localizadores += localizador.toString() + "\n";
        }
        return localizadores;
    }



}
