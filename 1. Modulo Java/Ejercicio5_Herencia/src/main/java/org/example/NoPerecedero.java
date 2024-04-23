package org.example;

//Creamos una clase que nos permite evidenciar la herencia como clase hija
public class NoPerecedero extends Producto{
    //Atributos
    private String tipo;

    //Constructor
    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    //Metodo de visualizacion de los atributos
    public String toString() {
        return super.toString() + "Tipo: " + tipo + "\n";
    }

    //Setters y Getters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
