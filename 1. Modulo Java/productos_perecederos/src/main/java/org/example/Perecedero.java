package org.example;

public class Perecedero extends Producto{
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
    public String toString() {
        return super.toString() + " Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        int descuento;
        switch (diasPorCaducar){
            case 1:
                descuento = 4;
                break;
            case 2:
                descuento = 3;
                break;
            case 3:
                descuento = 2;
                break;
            default:
                descuento = 1;

        }
        return super.calcular(cantidadDeProductos) / descuento;
    }
}
