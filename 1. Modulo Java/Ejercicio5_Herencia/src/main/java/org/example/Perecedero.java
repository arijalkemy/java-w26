package org.example;

//Creamos una clase que nos permite evidenciar la herencia como clase hija
public class Perecedero extends Producto{
    //con su atributo
    private int diasPorCaducar;

    //Constructor
    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    //Estructura de visualizacion de atributos
    public String toString() {
        return super.toString() + "Dias por Caducar: " + diasPorCaducar + "\n";
    }

    //Con su propia implementación del metodo padre
    public double calcular(int cantidadDeProductos) {
        double total = super.calcular(cantidadDeProductos);//haciendo uso del mismo metodo del padre
        if (diasPorCaducar == 1) {
            return total / 4;
        }
        if (diasPorCaducar == 2) {
            return total / 3;
        }
        if (diasPorCaducar == 3) {
            return total / 2;
        }
        return total;
    }

    //Setters y Getters
    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }
}
