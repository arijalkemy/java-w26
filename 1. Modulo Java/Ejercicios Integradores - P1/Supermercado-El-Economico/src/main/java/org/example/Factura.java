package org.example;

import java.util.List;

public class Factura {
    private long codigo;
    Cliente cliente;
    List<Item> items;
    double totalCompra;

    public Factura(long codigo, Cliente cliente, List<Item> items) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.items = items;
        this.calcularTotalFactura();
    }
    //metodo para calcular el total de la compra al crear una factura
    public void calcularTotalFactura(){
        for (Item item: items){
            totalCompra+=item.getCostoUnitario();
        }
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotalCompra() {
        return totalCompra;
    }


    @Override
    public String toString() {
        return "Factura{" +
                "codigo=" + codigo +
                ",cliente=" + cliente +
                ", items=" + items +
                ", totalCompra=" + totalCompra +
                '}';
    }
}
