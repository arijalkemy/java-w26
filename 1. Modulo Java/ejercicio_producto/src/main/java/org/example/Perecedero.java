package org.example;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio,int diasPorCaducar) {
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
    public double calcular(int cantidad) {

        double total = super.calcular(cantidad);
        int reduce = switch (diasPorCaducar) {
            case 1 -> 4;
            case 2 -> 3;
            case 3 -> 2;
            default -> 0;
        };
        return total - (total / reduce);
    }
}
