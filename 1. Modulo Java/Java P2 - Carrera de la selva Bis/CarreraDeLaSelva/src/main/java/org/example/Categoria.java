package org.example;

public class Categoria {
    private int id;
    private String nombre;
    private String descripcion;
    private int edadMinima;
    private double precioMenor;

    private double precioMayor;

    public Categoria(int id, String nombre, String descripcion, int edadMinima, double precioMenor, double precioMayor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.edadMinima = edadMinima;
        this.precioMenor = precioMenor;
        this.precioMayor = precioMayor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public double getPrecioMenor() {
        return precioMenor;
    }

    public void setPrecioMenor(double precioMenor) {
        this.precioMenor = precioMenor;
    }

    public double getPrecioMayor() {
        return precioMayor;
    }

    public void setPrecioMayor(double precioMayor) {
        this.precioMayor = precioMayor;
    }
}
