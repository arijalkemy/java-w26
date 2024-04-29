package org.example.services;

import org.example.Localizador;
import org.example.productos.BoletosDeViaje;
import org.example.productos.Comida;
import org.example.productos.Producto;
import org.example.productos.ReservaHotel;
import org.example.repositories.LocalizadorRepository;

import java.util.*;

public class ConsultasService {

    LocalizadorRepository localizadorRepository = new LocalizadorRepository();

    public void hacerConsultas() {
        int totalReservas = 0;
        List<Localizador> localizadores = localizadorRepository.getObjetos();
        System.out.printf("Cantidad Localizadores: ");
        System.out.println(localizadores.size());
        System.out.println("Cantidad total de reservas");
        for (Localizador localizador : localizadores) {
            totalReservas += localizador.getProductos().size();
        }
        HashMap<String, Set<Localizador>> reservasClasificadas = obtenerReservasClasficadas();
        for (Map.Entry<String, Set<Localizador>> mapa : reservasClasificadas.entrySet()) {
            System.out.println(mapa.getKey() + ": " + mapa.getValue().size());
        }
        System.out.println("Total: " + localizadores.stream().mapToDouble(Localizador::getTotal).sum());
        System.out.println("Promedio: " + localizadores.stream().mapToDouble(Localizador::getTotal).sum());
    }

    public HashMap<String, Set<Localizador>> obtenerReservasClasficadas() {
        HashMap<String, Set<Localizador>> reservasClasificadas = new HashMap<>();
        Set<Localizador> lzdrsBoletoViaje = new HashSet<>();
        Set<Localizador> lzdrsComida = new HashSet<>();
        Set<Localizador> lzdrsReservaHotel = new HashSet<>();
        Set<Localizador> lzdrsTransporte = new HashSet<>();
        for (Localizador localizador : localizadorRepository.getObjetos()) {
            for (Producto producto : localizador.getProductos()) {
                if (producto instanceof ReservaHotel) {
                    lzdrsReservaHotel.add(localizador);
                } else if (producto instanceof BoletosDeViaje) {
                    lzdrsBoletoViaje.add(localizador);
                } else if (producto instanceof Comida) {
                    lzdrsComida.add(localizador);
                } else {
                    lzdrsTransporte.add(localizador);
                }
            }
        }
        reservasClasificadas.put("Reservas Hotel", lzdrsReservaHotel);
        reservasClasificadas.put("Boletos De Viaje", lzdrsBoletoViaje);
        reservasClasificadas.put("Comida", lzdrsComida);
        reservasClasificadas.put("Transporte", lzdrsComida);
        return reservasClasificadas;
    }

}
