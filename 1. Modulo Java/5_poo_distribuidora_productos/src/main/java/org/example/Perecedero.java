package org.example;

// Item 2)
public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(double precio, String nombre, int diasPorCaducar) {
        super(precio, nombre);
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
        double basePrice = super.calcular(cantidadDeProductos);
        return switch (this.diasPorCaducar) {
            case 1 -> basePrice/4;
            case 2 -> basePrice/3;
            case 3 -> basePrice/2;
            default -> basePrice;
        };
    }

    @Override
    public String toString() {
        return super.toString() +
                "es Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
}
