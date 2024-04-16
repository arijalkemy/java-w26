package com.bootcamp.productos;

public class Perecedero extends Producto {
    private int diasPorCaducar = 0;

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero [diasPorCaducar=" + diasPorCaducar + "]";
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precio = super.calcular(cantidadDeProductos);
        if (diasPorCaducar == 1) {
            precio = precio / 4;
        } else if (diasPorCaducar == 2) {
            precio = precio / 3;
        } else if (diasPorCaducar == 3) {
            precio = precio / 2;
        }
        return precio;
    }
    
}
