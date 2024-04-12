package org.example.clases;

public class Perecedero extends Producto{

    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }
    @Override
    public double calcular (int cantidadDeProductos) {
        double resultado =  super.calcular(cantidadDeProductos);
        if (diasPorCaducar == 1) {
            return resultado * 0.25;
        }
        if (diasPorCaducar == 2) {
            return resultado / 3;
        }
        if (diasPorCaducar == 3) {
            return resultado * 0.5;
        }
        return resultado;
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
                '}';
    }
}
