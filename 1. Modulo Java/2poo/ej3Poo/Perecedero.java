package org.example;

public class Perecedero extends Producto{
    private int diasPorCaducar;

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(double precio, String nombre, int diasPorCaducar) {
        super(precio, nombre);
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
        double calcular = super.calcular(cantidadDeProductos);
        switch (diasPorCaducar){
            case 1: calcular = calcular/4;
                    break;
            case 2: calcular = calcular/3;
                    break;
            case 3: calcular = calcular/2;
                    break;
            default: calcular = calcular;


        }
        return super.calcular(cantidadDeProductos);
    }
}
