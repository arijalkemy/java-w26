package org.ggomezr;

import java.util.List;

public class Factura {
    private Long codigo;
    private Cliente cliente;
    private List<Item> items;
    private double totalCompra;
    private static Long ultimoCodigo = 0L;

    public Factura(Cliente cliente, List<Item> items) {
        this.codigo = ++ultimoCodigo;
        this.cliente = cliente;
        this.items = items;
        this.totalCompra = calcularTotalCompra();
    }

    public double calcularTotalCompra(){
        double total = 0;
        for (Item item: items){
            total += item.getCostoUnitario()*item.getCantidadComprada();
        }
        return total;
    }

    public Long getCodigo() {
        return codigo;
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

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", items=" + items +
                ", totalCompra=" + totalCompra +
                '}';
    }
}
