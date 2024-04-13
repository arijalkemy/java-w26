package org.example.models;

public class Item {
    private Long codigo;
    private String nombre;
    private int cantidadComprada;
    private double precioUnitario;

    public Long getCodigo() {
        return codigo;
    }

    public Item(long codigo, String nombre, int cantidadComprada, double precioUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadComprada = cantidadComprada;
        this.precioUnitario = precioUnitario;
    }

    public double getPrecioTotalItem(){
        return cantidadComprada * precioUnitario;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cantidadComprada=" + cantidadComprada +
                ", precioUnitario=" + precioUnitario +
                '}';
    }
}
