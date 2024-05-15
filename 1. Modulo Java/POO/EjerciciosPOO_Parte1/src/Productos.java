public class Productos  {

    //Atributos
    private String nombre;
    private double precio;
    //Constructores
    public Productos(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    //Métodos

    public double calcular(int cantidad){
        return this.precio*cantidad;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    //Getters y Setters
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
