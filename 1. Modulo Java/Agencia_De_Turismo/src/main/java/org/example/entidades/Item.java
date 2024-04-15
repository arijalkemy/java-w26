package org.example.entidades;

import org.example.enums.ItemTipo;

public class Item {
   private ItemTipo itemTipo;
   private Double precioUnitario;
   private Integer cantidad;

    public Item(ItemTipo itemTipo, Double precioUnitario, Integer cantidad) {
        this.itemTipo = itemTipo;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

    public ItemTipo getItemTipo() {
        return itemTipo;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Double calcularTotalItem(){
        return precioUnitario * cantidad;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemTipo=" + itemTipo +
                ", precioUnitario=" + precioUnitario +
                ", cantidad=" + cantidad +
                '}';
    }
}
