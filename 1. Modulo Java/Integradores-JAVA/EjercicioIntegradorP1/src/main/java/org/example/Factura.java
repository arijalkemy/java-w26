package org.example;

import java.util.List;

public class Factura {
    private int nroTicket;
    private String fecha;
    private Cliente cliente;
    private List<Producto> items;
    private double montoFactura;

    public Factura(){}
    public Factura(int nroTicket, String fecha, Cliente cliente, List<Producto> items) {
        this.nroTicket = nroTicket;
        this.fecha = fecha;
        this.cliente = cliente;
        this.items = items;
        this.montoFactura = costoTotal();
    }

    public double getMontoFactura() {
        return montoFactura;
    }

    public void setMontoFactura(double montoFactura) {
        this.montoFactura = montoFactura;
    }

    public int getNroTicket() {
        return nroTicket;
    }

    public void setNroTicket(int nroTicket) {
        this.nroTicket = nroTicket;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getItems() {
        return items;
    }

    public void setItems(List<Producto> items) {
        this.items = items;
    }

    public double costoTotal(){
        double total = 0;
        for (Producto item : items) {
           total += item.getCostoUnitario()* item.getCantidadComprada();
        };
        return total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "nroTicket=" + nroTicket +
                ", fecha='" + fecha + '\'' +
                ", cliente=" + cliente +
                ", items=" + items.toString() +
                ", montoFactura=" + montoFactura +
                '}';
    }
}
