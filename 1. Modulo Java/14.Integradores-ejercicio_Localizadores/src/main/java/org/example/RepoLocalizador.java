package org.example;

import java.util.ArrayList;
import java.util.List;

public class RepoLocalizador {
    private List<Localizador> localizadores = new ArrayList<>();


    public void guardarLocalizador(Localizador localizador) {
        double totalConDescuento;
        double descuentoFinal = 0;

        RepoCliente repoCliente = new RepoCliente();
        List<Localizador> reservasAnteriores = repoCliente.encontrarReservasCliente(localizadores, localizador.getCliente().getDni());

        if (reservasAnteriores.size() >= 2) {
            descuentoFinal += 0.05;
        }
        if (localizador.tieneTodasLasreservas()) {
            descuentoFinal += 0.10;
        }
        if (localizador.tieneDosReservasHoTelOviaje()) {
            descuentoFinal += 0.05;
        }

        totalConDescuento = localizador.getTotal() - descuentoFinal * localizador.getTotal();
        localizador.setDescuento(totalConDescuento);
        localizador.setDescuento(descuentoFinal);

        System.out.println(localizador.toString());
        localizadores.add(localizador);
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }
}
