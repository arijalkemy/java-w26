package org.example;

public class Categoria {
    private Integer id;
    private String nombre;
    private String descripcion;
    private double montoMenor;
    private double montoMayor;
    public Categoria(Integer id, String nombre, String descripcion, double montoMenor, double montoMayor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.montoMenor = montoMenor;
        this.montoMayor = montoMayor;
    }
    public double obtenerMonto (int edad) {
        if (edad < 18) {
            return montoMenor;
        }
        return montoMayor;
    }

    public String getNombre() {
        return nombre;
    }
}
