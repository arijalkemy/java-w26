package Producto;

public class Producto {
    private String nombre;
    private double precio;


    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    @Override
    public String toString(){
        return "Producto" + this.nombre + " de precio: " + this.precio;
    }

    public double calcular(int cantidadDeProductos){
        return this.precio * cantidadDeProductos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
