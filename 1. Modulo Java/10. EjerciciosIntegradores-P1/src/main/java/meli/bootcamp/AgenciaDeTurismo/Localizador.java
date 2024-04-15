package meli.bootcamp.AgenciaDeTurismo;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private Double total;



    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        reservas = new ArrayList<>();
    }

    public void agregarReserva(Reserva reserva) {
        this.reservas.add(reserva);
        this.total = reservas.stream().mapToDouble(Reserva::getValor).sum();
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Localizador{" + "cliente=" + cliente + ", reservas=" + reservas + ", total=" + total + '}';
    }
}
