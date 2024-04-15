package org.example;

public class Perecedero extends Producto{
    private int diasPorCaducar;
    public Perecedero(String nombre, double precio,int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar=diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return super.toString() + ", Dias por caducar: "+this.diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        try{
            if (cantidadDeProductos<=0){
                throw new IllegalArgumentException ("La cantidad de productos debe ser mayor a cero.");
            }
            double precioFinal= super.calcular(cantidadDeProductos);

            switch (this.diasPorCaducar){
                case 1:
                    precioFinal=precioFinal/4;
                    break;
                case 2:
                    precioFinal=precioFinal/3;
                    break;
                case 3:
                    precioFinal=precioFinal/2;
                    break;
                default:
                    break;
            }
            return precioFinal;
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return 0;

    }
}
