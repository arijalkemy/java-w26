package org.example;

public class Perecedero extends Producto{
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precio = getPrecio() * cantidadDeProductos;
        if (diasPorCaducar == 1){
            precio = precio * 0.25;
        }
        if (diasPorCaducar == 2){
            precio = precio * 0.33;
        }
        if (diasPorCaducar >= 3){
           precio = precio * 0.5;
        }
        return precio;
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
