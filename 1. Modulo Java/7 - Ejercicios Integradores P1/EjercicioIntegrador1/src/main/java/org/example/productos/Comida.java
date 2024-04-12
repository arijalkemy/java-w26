package org.example.productos;

public class Comida implements Producto{
    @Override
    public double getPrecio() {
        return 10000;
    }

    @Override
    public String getDescripcion() {
        return "Desayuno, Almuerzo y Cena";
    }
}
