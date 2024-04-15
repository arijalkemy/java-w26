package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Localizador {
    private Cliente cliente;
    private double total;
    private List<Reserva> listaReservas;

    public Localizador(Cliente cliente, List<Reserva> listaReservas) {
        this.cliente = cliente;
        this.listaReservas = listaReservas;
    }


    public void añadirReserva(Reserva reserva) {
            listaReservas.add(reserva);
        }

    public double obtenerTotalDeReserva(int reservasAnteriores) {
        // Hacer validación si la lista está vacía
        double descuento = calcularDescuento(reservasAnteriores);

        // Filtrar las reservas aplicables para el descuento adicional del 5%
        /*LEGACY RESERVAS
        List<Reserva> reservasAplicables = listaReservas.stream()
                .filter(reserva -> (reserva.getTipoReserva() == TipoReserva.HOTEL || reserva.getTipoReserva() == TipoReserva.VIAJES)
                        && (listaReservas.stream().filter(r -> r.getTipoReserva() == TipoReserva.HOTEL).toList().size() >= 2)
                        || (listaReservas.stream().filter(r -> r.getTipoReserva() == TipoReserva.VIAJES).toList().size() >= 2))
                .collect(Collectors.toList());
        */
        List<Reserva> reservasAplicables = new ArrayList<>();
        List<Reserva> reservasAplicablesHoteles = listaReservas.stream()
                .filter(reserva -> (reserva.getTipoReserva() == TipoReserva.HOTEL))
                .collect(Collectors.toList());
        List<Reserva> reservasAplicablesViajes = listaReservas.stream()
                .filter(reserva -> (reserva.getTipoReserva() == TipoReserva.VIAJES))
                .collect(Collectors.toList());
       if(reservasAplicablesHoteles.size() >=2){
           for (Reserva reserva: reservasAplicablesHoteles) {
               reservasAplicables.add(reserva);
           }
       }

        if(reservasAplicablesViajes.size() >=2){
            for (Reserva reserva: reservasAplicablesViajes) {
                reservasAplicables.add(reserva);
            }
        }
        // Filtrar las reservas no aplicables para el descuento adicional
        List<Reserva> reservasNoAplicables = listaReservas.stream()
                .filter(reserva -> !reservasAplicables.contains(reserva))
                .collect(Collectors.toList());
        // Aplicar descuento a las reservas aplicables y no aplicables por separado
        System.out.println("Reservas SIN descuentos adicionales"+reservasNoAplicables.toString());
        double totalConDescuento = reservasNoAplicables.stream()
                .mapToDouble(reserva -> reserva.getCostoConDescuentoReserva(descuento))
                .sum();
        System.out.println("Reservas CON descuentos adicionales"+reservasAplicables.toString());
        double totalConDescuentoAdicional = reservasAplicables.stream()
                .mapToDouble(reserva -> reserva.getCostoConDescuentoReserva(descuento + 0.05))
                .sum();

        // Devolver el costo total con los descuentos ya aplicados
        return totalConDescuento + totalConDescuentoAdicional;
    }

    public double calcularDescuento(int reservasAnteriores) {
        double descuentoAcumulado = 0.0;
        if (reservasAnteriores >= 2) {
            descuentoAcumulado = 0.05;
        }

        if (listaReservas.stream().anyMatch(reserva -> reserva.getTipoReserva() == TipoReserva.HOTEL)
            && listaReservas.stream().anyMatch(reserva -> reserva.getTipoReserva() == TipoReserva.COMIDA)
            && listaReservas.stream().anyMatch(reserva -> reserva.getTipoReserva() == TipoReserva.VIAJES)
            && listaReservas.stream().anyMatch(reserva -> reserva.getTipoReserva() == TipoReserva.TRANSPORTE)
        ){
            descuentoAcumulado += descuentoAcumulado + 0.1;
        }

        return  descuentoAcumulado;

    }

    @Override
    public String toString() {
        return "cliente= " + cliente.toString() +
                "\n--listaReservas-- \n"+ listaReservas.stream()
                .map(Reserva::toString)
                .collect(Collectors.joining("\n"));
    }



}
