package org.bootcamp.domain;

public class Item {

    private static int contadorId = 0;
private int codigoItem;
private String nombre;
private int cantidadComprada;
private double costoUnitario;

    public Item() {
        this.codigoItem = ++contadorId;
    }

    public Item(String nombre, int cantidadComprada, double costoUnitario) {
        this.nombre = nombre;
        this.cantidadComprada = cantidadComprada;
        this.costoUnitario = costoUnitario;
    }

    public int getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(int codigoItem) {
        this.codigoItem = codigoItem;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(int cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("\ncodigo Item: ").append(codigoItem);
        sb.append("\nnombre: ").append(nombre);
        sb.append("\ncantidad comprada: ").append(cantidadComprada);
        sb.append("\ncosto unitario: ").append(costoUnitario);
        return sb.toString();
    }
}
