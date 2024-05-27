package org.example;

public class Perecedero extends Producto{
    public Perecedero(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        return 0; //Método no utilizable para esta clase
    }

    public double calcular(int cantidadDeProductos,int diasPorCaducar){
        switch (diasPorCaducar){
            case 1:
                return (getPrecio()*cantidadDeProductos)/4;
            case 2:
                return (getPrecio()*cantidadDeProductos)/3;
            case 3:
                return (getPrecio()*cantidadDeProductos)/2;
            default:
                return getPrecio()*cantidadDeProductos;
        }
    }

}
