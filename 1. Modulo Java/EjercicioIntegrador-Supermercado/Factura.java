package Supermercado;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> listaDeItem = new ArrayList<>();
    private double totalCompra;

   public Factura(Cliente cliente, List<Item> listaDeItem) {
        this.cliente = cliente;
        this.listaDeItem = listaDeItem;
    }

    //El campo total de la factura es un campo calculado, por lo cual,
    // para poder asignar este valor deberemos recorrer la lista de items y
    // realizar las operaciones matemáticas necesarias para obtener el total.

    public void calcularTotalFactura(Factura factura){
        double total = 0;
        for(Item item : factura.getListaDeItem()){
            total += item.getCantidad() * item.getPrecio();
        }
        factura.setTotalCompra(total);
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", listaDeItem=" + listaDeItem +
                ", totalCompra=" + totalCompra +
                '}';
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getListaDeItem() {
        return listaDeItem;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }
}
