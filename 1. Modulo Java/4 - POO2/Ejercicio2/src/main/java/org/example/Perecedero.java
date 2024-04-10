package org.example;

public class Perecedero extends Producto{
    int diasPorCaducar;

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
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

    @Override
    public double calcular(int cantidadDeProductos){
        switch (this.diasPorCaducar){
            case 1:
                return super.calcular(cantidadDeProductos) / 4;

            case 2:
                return super.calcular(cantidadDeProductos) / 3;

            case 3:
                return super.calcular(cantidadDeProductos) / 2;

            default:
                return super.calcular(cantidadDeProductos);
        }
    }
}
