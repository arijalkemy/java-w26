package org.example.distribuidora;

public class Perecedero extends Producto{

    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {

        double precioProducto = super.getPrecio();
        if(this.diasPorCaducar == 1){
            return (precioProducto * cantidadDeProductos) / 4;
        } else if (this.diasPorCaducar == 2) {
            return (precioProducto * cantidadDeProductos) / 3;
        } else if (this.diasPorCaducar == 3) {
            return (precioProducto * cantidadDeProductos) / 2;
        }
        return super.calcular(cantidadDeProductos);
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(String nombre, double precio) {
        super(nombre, precio);
    }
}
