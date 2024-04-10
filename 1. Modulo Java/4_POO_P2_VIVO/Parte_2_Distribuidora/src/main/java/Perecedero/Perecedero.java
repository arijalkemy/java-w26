package Perecedero;

import Producto.Producto;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio,int diasPorCaducar) {
        super(nombre,precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos){
        double multiplicador;
        switch (diasPorCaducar){
            case 1 -> {
                multiplicador = 4;
            }
            case 2 -> {
                multiplicador = 3;
            } default -> {
                multiplicador = 0.5;
            }
        }
        return super.calcular(cantidadDeProductos) - (this.getPrecio() * multiplicador);
    }

    @Override
    public String toString(){
        return "Dias por cadudar: " + this.diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }
}
