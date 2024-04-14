package org.example.classes;

public class Reserva {
    private Producto producto;
    private float costo;
    private int cantidad;

    public Reserva(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.costo=calcularCosto();
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    private float calcularCosto() {
        return cantidad*producto.getCosto();
    }

    @Override
    public String toString() {
        return "{ producto: " + producto.getNombre() +
                ", costo: " + costo +
                ", cantidad: " + cantidad + " }";
    }
}
