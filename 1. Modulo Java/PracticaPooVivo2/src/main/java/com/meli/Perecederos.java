package com.meli;

public class Perecederos extends Producto {
    private int diasACaducar;

    public Perecederos(String nombre, double precio, int diasACaducar) {
        super(nombre, precio);
        this.diasACaducar = diasACaducar;
    }

    public int getDiasACaducar() {
        return diasACaducar;
    }

    public void setDiasACaducar(int diasACaducar) {
        this.diasACaducar = diasACaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precio = super.getPrecio();
        if (diasACaducar == 1) {
            precio = precio / 4;
        } else if (diasACaducar == 2) {
            precio = precio / 3;
        } else if (diasACaducar == 3) {
            precio = precio / 2;
        }
        return precio * cantidadDeProductos;
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + ", Precio: " + getPrecio() + ", Dias para caducar: " + diasACaducar;
    }
}