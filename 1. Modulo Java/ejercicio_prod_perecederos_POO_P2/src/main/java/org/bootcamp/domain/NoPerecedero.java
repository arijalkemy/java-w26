package org.bootcamp.domain;

public class NoPerecedero extends Producto{

    private String tipo;

    public NoPerecedero() {
    }

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
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
        final StringBuffer sb = new StringBuffer("NoPerecedero{");
        sb.append("tipo: ").append(tipo);
        sb.append(", nombre: ").append(super.getNombre());
        sb.append(", precio: ").append(super.getPrecio());
        sb.append('}');
        return sb.toString();
    }


}
