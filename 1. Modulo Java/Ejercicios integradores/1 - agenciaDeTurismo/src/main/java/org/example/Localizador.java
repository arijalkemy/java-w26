package org.example;
import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private int id;
    private Cliente cliente;
    private List<DetalleReserva> detallesReserva;
    private double total;

    // Constructor
    public Localizador(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.detallesReserva = new ArrayList<>();
        this.total = 0.0;
    }

    // Getters y Setters
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

    public List<DetalleReserva> getDetallesReserva() {
        return detallesReserva;
    }

    public void setDetallesReserva(List<DetalleReserva> detallesReserva) {
        this.detallesReserva = detallesReserva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    // Método para agregar un detalle de reserva
    public void agregarDetalleReserva(DetalleReserva detalle) {
        if (detalle != null) {
            this.detallesReserva.add(detalle);
            recalcularTotal();
        }
    }

    // Método privado para recalcular el total cada vez que se añade un nuevo detalle de reserva
    private void recalcularTotal() {
        this.total = detallesReserva.stream().mapToDouble(DetalleReserva::getMonto).sum();
    }

    // Método toString para imprimir detalles del localizador de manera conveniente
    @Override
    public String toString() {
        return "Localizador{" +
                "id=" + id +
                ", cliente=" + cliente.getNombre() +
                ", total=" + total +
                '}';
    }
}
