package bootcamp.bendezujonathan;

public class Producto {

    private String nombre;
    private double precio;


    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }


    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    @Override
    public String toString(){
        return String.format(">> Producto:  %s Pricing: %.2f", this.nombre, this.precio);
    }

    public double calcular(int cantidad){
        return this.precio * cantidad;
    }
}
