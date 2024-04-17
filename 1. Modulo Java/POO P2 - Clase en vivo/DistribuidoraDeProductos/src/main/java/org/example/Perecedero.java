package org.example;

public class Perecedero extends Producto {
    int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precioTotal =  super.calcular(cantidadDeProductos);
        if(this.diasPorCaducar == 1) precioTotal = precioTotal/4;
        if(this.diasPorCaducar == 2) precioTotal = precioTotal/3;
        if(this.diasPorCaducar == 3) precioTotal = precioTotal/2;

        return precioTotal;


    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
