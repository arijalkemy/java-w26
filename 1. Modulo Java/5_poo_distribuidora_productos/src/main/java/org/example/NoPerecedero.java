package org.example;

// item 3)
public class NoPerecedero extends Producto {
    private String tipo;

    public NoPerecedero(double precio, String nombre, String tipo) {
        super(precio, nombre);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() +
                "es NoPerecedero{" +
                "tipo='" + tipo + '\'' +
                '}';
    }
}
