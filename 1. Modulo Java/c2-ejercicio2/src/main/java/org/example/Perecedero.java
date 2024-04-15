package org.example;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precioFinal = super.calcular(cantidadDeProductos);
        if (diasPorCaducar <= 1) {
            precioFinal /= 4;
        } else if (diasPorCaducar <= 2) {
            precioFinal /= 3;
        } else if (diasPorCaducar <= 3) {
            precioFinal /= 2;
        }
        return precioFinal;
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + " Precio: " + getPrecio() + " Dias por caducar: " + getDiasPorCaducar();
    }
    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public Perecedero setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
        return this;
    }
}
