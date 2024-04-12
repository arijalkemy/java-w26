package org.example.ejercicio2;

public class Perecedero extends Producto {

    private int diasPorCaducar;


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

    @Override
    public double calcular(int cantidadDeProductos) {
        double precioBase = super.calcular(cantidadDeProductos);

        if (diasPorCaducar == 1)
            return precioBase / 4;

        if (diasPorCaducar == 2)
            return precioBase / 3;

        if (diasPorCaducar == 3)
            return precioBase / 2;

        return precioBase;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
            "diasPorCaducar=" + diasPorCaducar +
            "} " + super.toString();
    }
}
