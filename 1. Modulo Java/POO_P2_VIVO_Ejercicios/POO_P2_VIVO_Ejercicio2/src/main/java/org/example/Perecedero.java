package org.example;

public class Perecedero extends Producto{
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precioFinal;
        precioFinal = super.calcular(cantidadDeProductos);

        switch (this.diasPorCaducar){
            case 1:
                precioFinal = precioFinal / 4;
                break;
            case 2:
                precioFinal = precioFinal / 3;
                break;
            case 3:
                precioFinal = precioFinal / 2;
                break;
        }
        return precioFinal;
    }
}
