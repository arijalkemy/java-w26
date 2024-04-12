package org.example;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    List<LocalizadorTuristico> localizadores;

    public Repositorio() {
        this.localizadores = new ArrayList<>();
    }

    public List<LocalizadorTuristico> getLocalizadores() {
        return localizadores;
    }

    public void agregarPaguete(LocalizadorTuristico paquete) {

        List<LocalizadorTuristico> paquetesDelCliente = buscarLocalizadoresPorCliente(paquete.getCliente().getDni());
        double desc = 0;

        if (!paquetesDelCliente.isEmpty())
            desc += 0.05;

        if (paquete.tieneTodoTipoReserva())
            desc += 0.1;

        if (paquete.tiene2Hoteleso2Boletos())
            desc += 0.05;

        paquete.setDescuento(desc);
        paquete.setPrecioConDescuento(paquete.getPrecioTotal() * (1 - desc));

        this.localizadores.add(paquete);
    }

    public List<LocalizadorTuristico> buscarLocalizadoresPorCliente(String dni) {
        return localizadores.stream().filter(p -> p.getCliente().getDni().equals(dni)).toList();
    }
}
