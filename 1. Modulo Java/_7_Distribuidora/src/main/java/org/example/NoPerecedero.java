package org.example;

public class NoPerecedero extends Producto{
    private String tipo;
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    public String toString(){
        return "El nombre es " + super.getPrecio() + ". El precio es: " + super.getPrecio() + ". El tipo es: " + this.tipo;
    }

    
}
