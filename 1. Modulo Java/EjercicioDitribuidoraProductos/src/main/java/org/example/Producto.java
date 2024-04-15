package org.example;

//clase abstracta del objeto Producto
public abstract  class  Producto {
    private String nombre; //Atributos de las clases
    private double precio;

    public Producto(String nombre,double precio){ //Costructor del objeto producto
        this.precio=precio;
        this.nombre=nombre;
    }
    //Getters y Setters de la clase
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
    //Metodo toString de la clase
    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
    // Metodo calcular, devuelve el total de precio de un producto y la cantidad.
    public double calcular(int cantidadDeProductos){
        return cantidadDeProductos * precio;
    }
}
