package org.example;

public class Perecedero extends Producto {

    private int diasPorCaducar;

    @Override
    public String toString() {
        return "Días por caducar: " + this.diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precioBase = super.calcular(cantidadDeProductos);
        if (diasPorCaducar == 1) {
            return precioBase / 4;
        } else if (diasPorCaducar == 2) {
            return precioBase / 3;
        } else if (diasPorCaducar == 3) {
            return precioBase / 2;
        } else {
            return precioBase;
        }
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }
}
