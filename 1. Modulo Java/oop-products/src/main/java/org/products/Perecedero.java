package org.products;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return super.toString() + " Dias por caducar: " + diasPorCaducar;
    }

    @Override
    public void calcular(int cantidadDeProductos) {
        super.calcular(cantidadDeProductos);

        switch (diasPorCaducar) {
            case 1:
                this.precio = this.precio / 4;
                break;
            case 2:
                this.precio = this.precio / 3;
                break;
            case 3:
                this.precio = this.precio / 2;
                break;
        }
    }
}
