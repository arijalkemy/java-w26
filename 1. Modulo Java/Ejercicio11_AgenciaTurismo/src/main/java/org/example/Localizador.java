package org.example;

import org.example.productos.*;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private Cliente cliente;
    private double total = 0;
    private List<Producto> productos = new ArrayList<>();
    private int porcentajeDescuento = 0;

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
    }

    public void agregarPaqueteCompleto() {
        productos.add(new BoletosDeViaje());
        productos.add(new Comida());
        productos.add(new ReservaHotel());
        productos.add(new Transporte());
        if (porcentajeDescuento == 0) {
            porcentajeDescuento = 10;
        }
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
    }

    public void agregarPaqueteDosHoteles() {
        ReservaHotel reservaHotel = new ReservaHotel();
        productos.add(reservaHotel);
        productos.add(reservaHotel);
        total += (reservaHotel.getPrecio() * 2) * 0.95;
    }

    public void agregarPaqueteDosBoletos() {
        BoletosDeViaje boletosDeViaje = new BoletosDeViaje();
        productos.add(boletosDeViaje);
        productos.add(boletosDeViaje);
        total += (boletosDeViaje.getPrecio() * 2) * 0.95;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
        total += producto.getPrecio();
    }

    public double getTotal() {
        int descuentoExtra = 0;
        if (cliente.getCantLocalizadores() > 2) {
            descuentoExtra = 5;
        }
        return total - (total * descuentoExtra / 100) - (total * porcentajeDescuento / 100);
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
