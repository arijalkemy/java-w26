package org.example;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> listaItems;
    private Double totalCompra;

    public Factura(Cliente cliente, List<Item> listaItems) {
        this.cliente = cliente;
        this.listaItems = listaItems;
        this.totalCompra = calcularTotalCompra(listaItems);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<Item> listaItems) {
        this.listaItems = listaItems;
    }

    public Double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
    }

    private Double calcularTotalCompra(List<Item> listaItems)
    {
        Double resultado = 0.0;

        for (Item item: listaItems) {
            resultado += item.getCostoUnitario();
        }
        return  resultado;
    }

    public Boolean existeClienteLista(List<Cliente> listaCliente,Cliente cliente)
    {

        for (Cliente item : listaCliente) {
            Integer dni = cliente.getDni();
            if(cliente.getDni() == item.getDni())
            {
                return true;
            }
        }
        return false;
    }
}
