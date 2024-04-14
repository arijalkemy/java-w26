package org.example.classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Localizador {
    private int id;
    private Cliente cliente;
    private float total;
    private LocalDateTime fecha;
    List <Reserva> reservas;
    private boolean tiene2Localizadores;

    public Localizador(int id, Cliente cliente, LocalDateTime fecha, List<Reserva> reservas, boolean tiene2Localizadores) {
        this.id = id;
        this.cliente = cliente;
        this.fecha = fecha;
        this.reservas = reservas;
        this.tiene2Localizadores = tiene2Localizadores;
        this.total = calcularTotal();

    }

    public boolean isTiene2Localizadores() {
        return tiene2Localizadores;
    }

    public void setTiene2Localizadores(boolean tiene2Localizadores) {
        this.tiene2Localizadores = tiene2Localizadores;
    }

    public Localizador(int id, Cliente cliente, LocalDateTime fecha, List<Reserva> reservas) {
        this.id = id;
        this.cliente = cliente;
        this.fecha = fecha;
        this.reservas = reservas;
        this.total = calcularTotal();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    private float calcularTotal() {
        // Se aplica el descuento por paqueteCompleto
        float total = (float) reservas
                .stream()
                .mapToDouble(Reserva::getCosto)
                .sum();

        float descuentoTotal = aplicarDescuentos();

        return total * (1 - descuentoTotal);
    }

    private float aplicarDescuentos() {
        float descuentoTotal = 0;

        if (esPaqueteCompleto()) {
            descuentoTotal += 0.1F;
            System.out.println(" - 10% de descuento: Paquete completo.");
        }

        if (tiene2Localizadores) {
            descuentoTotal += 0.05F;
            System.out.println(" - 5% de descuento: Mas de 2 localizadores.");
        }

        // Se aplica el descuento en caso de tener 2 reservas de hotel o 2 boletos de viaje
        if (tiene2Deltipo(0) || tiene2Deltipo(2)) {
            reservas.forEach(reserva -> {
                aplicarDescuentoAlTipo(0, 0.05F, reserva);
                aplicarDescuentoAlTipo(2, 0.05F, reserva);
            });
            System.out.println(" - 5% de descuento: 2 reservas de hotel o 2 boletos de viaje.");
        };

        return descuentoTotal;
    }

    private boolean esPaqueteCompleto() {
        boolean tieneHotel = reservas
                .stream()
                .anyMatch(reserva -> reserva.getProducto().getTipoProducto().getId() == 0);
        boolean tieneComida = reservas
                .stream()
                .anyMatch(reserva -> reserva.getProducto().getTipoProducto().getId() == 1);
        boolean tieneBoleto = reservas
                .stream()
                .anyMatch(reserva -> reserva.getProducto().getTipoProducto().getId() == 2);
        boolean tieneTransporte = reservas
                .stream()
                .anyMatch(reserva -> reserva.getProducto().getTipoProducto().getId() == 3);

        return tieneHotel && tieneComida && tieneBoleto && tieneTransporte;
    }

    private boolean tiene2Deltipo(int idTipo) {
        int reservasDeTipo = reservas
                .stream()
                .filter(reserva -> reserva.getProducto().getTipoProducto().getId() == idTipo)
                .toList()
                .size();

        if (reservasDeTipo >= 2) return true;
        return false;
    }

    private void aplicarDescuentoAlTipo(int idTipo, float descuento, Reserva reserva) {
        if(tiene2Deltipo(idTipo) && reserva.getProducto().getTipoProducto().getId() == idTipo) {
            reserva.setCosto(reserva.getCosto() * (1 - descuento));
        }
    }

    @Override
    public String toString() {
        return "Localizador:" +
                "\n - id: " + id +
                "\n - cliente: " + cliente.getNombre() +
                "\n - total: " + total +
                "\n - fecha: " + fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                "\n - reservas: " + reservas;
    }
}
