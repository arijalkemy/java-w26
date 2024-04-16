package org.example;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    List<LocalizadorTuristico> paquetes;

    public Repositorio() {
        this.paquetes = new ArrayList<>();
    }

    public List<LocalizadorTuristico> getPaquetes() {
        return paquetes;
    }

    public void agregarPaguete(LocalizadorTuristico paquete) {
        List<LocalizadorTuristico> paquetesDelCliente = buscarPaquetesPorCliente(paquete.getCliente().getDni());
        double desc = 0;
        if(!paquetesDelCliente.isEmpty()){
            desc += 0.05;
        }
        if(paquete.tieneTodoTipoReserva()){
            desc += 0.1;
        }
        if(paquete.tieneHoteloBoleto()){
            desc += 0.05;
        }

        paquete.setDescuento(desc);
        paquete.setPrecioConDescuento(paquete.getPrecioTotal() * (1 - desc));

        this.paquetes.add(paquete);
    }

    public List<LocalizadorTuristico> buscarPaquetesPorCliente(String dni) {
        return paquetes.stream().filter(p -> p.getCliente().getDni().equals(dni)).toList();
    }
}
