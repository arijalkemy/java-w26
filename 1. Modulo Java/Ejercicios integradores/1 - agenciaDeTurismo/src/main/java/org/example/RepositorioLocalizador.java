package org.example;
import java.util.*;


import java.util.ArrayList;
import java.util.List;

public class RepositorioLocalizador {
    private List<Localizador> localizadores;

    public RepositorioLocalizador() {
        this.localizadores = new ArrayList<>();
    }

    // Agrega un localizador al repositorio
    public void agregarLocalizador(Localizador localizador) {
        if (localizador != null) {
            this.localizadores.add(localizador);
            aplicarDescuentos(localizador);
        }
    }

    // Aplica descuentos según las reglas del negocio
    public void aplicarDescuentos(Localizador localizador) {
        // Aplicación de descuentos según la lógica de negocio
        Cliente cliente = localizador.getCliente();
        long cuentaLocalizadores = cliente.getLocalizadores().size();

        // Si el cliente tiene al menos 2 localizadores anteriores, se aplica un 5% de descuento al total
        if (cuentaLocalizadores >= 2) {
            localizador.setTotal(localizador.getTotal() * 0.95);
        }

        // Si el localizador tiene reservas de todos los tipos necesarios, se aplica un descuento del 10%
        if (tieneReservasCompletas(localizador)) {
            localizador.setTotal(localizador.getTotal() * 0.90);
        }

        // Otros descuentos pueden ser añadidos aquí
    }

    // Verifica si el localizador tiene un "paquete completo"
    private boolean tieneReservasCompletas(Localizador localizador) {
        boolean tieneHotel = false, tieneComida = false, tieneBoleto = false, tieneTransporte = false;
        for (DetalleReserva dr : localizador.getDetallesReserva()) {
            switch (dr.getTipo()) {
                case "hotel":
                    tieneHotel = true;
                    break;
                case "comida":
                    tieneComida = true;
                    break;
                case "boleto":
                    tieneBoleto = true;
                    break;
                case "transporte":
                    tieneTransporte = true;
                    break;
            }
        }
        return tieneHotel && tieneComida && tieneBoleto && tieneTransporte;
    }

    // Devuelve una copia de la lista de todos los localizadores
    public List<Localizador> obtenerTodosLocalizadores() {
        return new ArrayList<>(localizadores);
    }
}
