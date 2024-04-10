package Ejercicio2;

public class Perecedero extends Producto {
    private int diasPorCadudar;

    public Perecedero( String nombre, double precio,int diasPorCaducar){
        super(nombre,precio);
        this.diasPorCadudar = diasPorCaducar;
    }

    public int getDiasPorCadudar() {
        return diasPorCadudar;
    }

    public void setDiasPorCadudar(int diasPorCadudar) {
        this.diasPorCadudar = diasPorCadudar;
    }

    public String toString(){

        return super.toString() + " Dias por caducar: " + this.diasPorCadudar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        int descuento = 1;
        switch(this.diasPorCadudar){
            case 1:
                descuento = 4;
                break;
            case 2:
                descuento = 3;
                break;
            case 3:
                descuento = 2;
                break;
        }
        return ( getPrecio() * cantidadDeProductos ) / descuento;
    }
}
