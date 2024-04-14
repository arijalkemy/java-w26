package org.example;

public class Perecedero extends Producto {

    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }


    public String toString() {
        return super.toString() + "Dias por Caducar: " + diasPorCaducar + "\n";
    }

    public double calcular(int cantidadDeProductos) {
        double total = super.calcular(cantidadDeProductos);
        if (diasPorCaducar == 1) {
            return total / 4;
        }
        if (diasPorCaducar == 2) {
            return total / 3;
        }
        if (diasPorCaducar == 3) {
            return total / 2;
        }
        return total;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }
}
