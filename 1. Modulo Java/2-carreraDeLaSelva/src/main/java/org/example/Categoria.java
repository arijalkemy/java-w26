package org.example;

public class Categoria {
    private String id;
    private String nombre;
    private String descripcion;
    private int precioMayores;
    private int precioMenores;

    public Categoria(String id, String nombre, String descripcion, int precioMayores, int precioMenores) {
        this.id = id;
        this.precioMenores = precioMenores;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.precioMayores = precioMayores;
    }

    public double montoSegunEdad(int edad) {
        double monto = precioMenores;
        if (edad >= 18) {
            monto = precioMayores;
        }
        return monto;
    }

    public int getPrecioMenores() {
        return precioMenores;
    }

    public void setPrecioMenores(int precioMenores) {
        this.precioMenores = precioMenores;
    }

    public int getPrecioMayores() {
        return precioMayores;
    }

    public void setPrecioMayores(int precioMayores) {
        this.precioMayores = precioMayores;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
