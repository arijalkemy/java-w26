package com.company;

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

    private int factorDeReducción() {
        if(diasPorCaducar == 1) return 4;
        if(diasPorCaducar == 2) return 3;
        if(diasPorCaducar == 3) return 2;
        return 1;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        return super.calcular(cantidadDeProductos)/factorDeReducción();
    }
}
