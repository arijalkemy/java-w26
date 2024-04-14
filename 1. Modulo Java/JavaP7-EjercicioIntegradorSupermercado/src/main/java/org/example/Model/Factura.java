package org.example.Model;

import org.example.Collections.ItemCollection;

import java.util.List;

public class Factura {

    Integer folio;
    Cliente cliente;
    ItemCollection productos;

    public Factura(Cliente cliente, ItemCollection productos) {
        this.cliente = cliente;
        this.productos = productos;
    }

    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemCollection getProductos() {
        return productos;
    }

    public void setProductos(ItemCollection productos) {
        this.productos = productos;
    }

    public double calculaFactura(){
        return this.productos.getProductos().stream().mapToDouble(p->p.getCostoUnitario()*p.getCantidadComprada()).sum();
    }

    @Override
    public String toString() {
        return "Factura{" +
                "folio=" + folio +
                ", cliente=" + cliente +
                ", productos=" + productos +
                '}';
    }
}
