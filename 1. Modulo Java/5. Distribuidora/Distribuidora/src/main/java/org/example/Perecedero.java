package org.example;

public class Perecedero extends  Producto{
    private int diasPorCaducar;

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
        return "Precio final del producto ";
    }

    private double factorDeReduccion () {
        if (this.diasPorCaducar <= 1) {
            return 4.0;
        } else if (this.diasPorCaducar <= 2){
            return 3.0;
        } else if (this.diasPorCaducar <= 3){
            return 2.0;
        } else {
            return 1.0;
        }
    }

    @Override
    public double Calcular(int CantidadDeProductos) {
        double valorProducto = super.Calcular(CantidadDeProductos);
        double reduccionDePrecio = factorDeReduccion();
        double total = valorProducto / reduccionDePrecio;

        return total;
    }
}
