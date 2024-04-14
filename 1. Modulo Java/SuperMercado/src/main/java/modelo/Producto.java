package modelo;

public class Producto {

    public String nombre;
    public double costoUnitario;

    public Producto(String nombre, double costoUnitario) {
        this.nombre = nombre;
        this.costoUnitario = costoUnitario;
    }

    @Override
    public String toString(){
        return this.nombre + ", precio: " + this.costoUnitario;
    }
}
