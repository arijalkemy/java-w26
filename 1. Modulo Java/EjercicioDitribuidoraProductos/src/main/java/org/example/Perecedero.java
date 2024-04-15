package org.example;

//Clase del objeto perecedero que hereda de producto
public class Perecedero extends Producto{
    private int diasPorCaducar; //Atributos de la clase

    //Constructor de la clase perecedero
    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }
    //Metodos Getter y setter de la clase
    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    //Metodo toString de la clase
    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
    //Metodo para calcular el valor del producto en descuento
    @Override
    public double calcular(int cantidadDeProductos){
        double resultado;
        switch (diasPorCaducar){
            case 1:
                resultado= super.calcular(cantidadDeProductos)/4;
                break;
            case 2:
                resultado= super.calcular(cantidadDeProductos)/3;
                break;
            case 3:
                resultado= super.calcular(cantidadDeProductos)/2;
                break;
            default:
                resultado= super.calcular(cantidadDeProductos);
        }
        return resultado;
    }
}