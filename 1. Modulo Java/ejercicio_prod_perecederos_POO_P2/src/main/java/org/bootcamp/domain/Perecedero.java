package org.bootcamp.domain;

public class Perecedero extends Producto{

    private int diasPorCaducar;

    public Perecedero() {
    }

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
        final StringBuffer sb = new StringBuffer("Perecedero{");
        sb.append("diasPorCaducar: ").append(diasPorCaducar);
        sb.append(", nombre: ").append(super.getNombre());
        sb.append(", precio: ").append(super.getPrecio());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public double calcular(int cantidadDeProducto) {
        double precioFinal = super.calcular(cantidadDeProducto);

        switch (this.diasPorCaducar) {
            case 1:
                return precioFinal / 4;
            case 2:
                return precioFinal / 3;
            case 3:
                return precioFinal / 2;
            default:
                return precioFinal;
        }
    }
}
