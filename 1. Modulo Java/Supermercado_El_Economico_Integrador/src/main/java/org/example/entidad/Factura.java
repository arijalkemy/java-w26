package org.example.entidad;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> listaDeItems;
    private Double totalDeLaCompra;
    private Long codigo;
    private static Long nextCodigo = 1L;

    public Factura(List<Item> listaDeItems, Cliente cliente) {
        this.listaDeItems = listaDeItems;
        this.cliente = cliente;
        this.codigo = nextCodigo;
        this.totalDeLaCompra = calcularTotal(listaDeItems);
        nextCodigo++;
    }

    public Long getCodigo() {
        return codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getListaDeItems() {
        return listaDeItems;
    }

    public Double getTotalDeLaCompra(){
        return totalDeLaCompra;
    }

    private Double calcularTotal(List<Item> listaDeItems){
        return listaDeItems.stream()
                .mapToDouble(Item::calcularCantidadTotal)
                .sum();

    }
    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", listaDeItems=" + listaDeItems +
                ", totalDeLaCompra=" + totalDeLaCompra +
                '}';
    }
}
