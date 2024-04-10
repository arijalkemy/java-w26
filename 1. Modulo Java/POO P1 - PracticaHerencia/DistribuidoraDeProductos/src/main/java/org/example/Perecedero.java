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
    public double calcular(int cantidadDeProductos) {
        double resultado = cantidadDeProductos * this.getPrecio();
        double descuento = 0;

        switch (this.diasPorCaducar){
            case 3:
                descuento = 0.50;
                break;
            case 2:
                descuento = 0.75;
                break;
            case 1:
                descuento = 0.875;
                break;
        }

        return resultado - (resultado * descuento);
    }
}
