package com.bootcamp.productos;

public class NoPercedero extends Producto {
    private String tipo = "";

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public NoPercedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "NoPercedero [tipo=" + tipo + "]";
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        return super.calcular(cantidadDeProductos);
    }
}
