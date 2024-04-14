package org.example;

public class Item {
    int código;
    String nombre;
    int cantidadComprada;
    double costoUnitario;

    public Item(int código, String nombre, int cantidadComprada, double costoUnitario) {
        this.código = código;
        this.nombre = nombre;
        this.cantidadComprada = cantidadComprada;
        this.costoUnitario = costoUnitario;
    }
}
