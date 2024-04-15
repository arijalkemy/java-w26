package org.example.model;

import org.example.repository.RepositorioLocalizador;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private Integer id;
    private Cliente cliente;
    private List<Reserva> reservas;
    private Double montoTotal;
    private LocalDateTime fecha;

    public Localizador(Cliente cliente, LocalDateTime fecha) {
        this.cliente = cliente;
        this.reservas = new ArrayList<>();
        this.montoTotal = montoTotal;
        this.fecha = fecha;
    }
    public void agregarReserva(Reserva reserva) {
        this.montoTotal += reserva.getPrecio();
        this.reservas.add(reserva);
    }
    public void aplicarDescuento(int porcentaje) {
        this.montoTotal = this.montoTotal * (100 - (porcentaje/100));
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
