package org.example.model;

public class Iteam {
    private Long codigo;
    private String nombre;
    private int catidad;
    private double costoUnitario;

    public Iteam() {
    }

    public Iteam(Long codigo, String nombre, int catidad, double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.catidad = catidad;
        this.costoUnitario = costoUnitario;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCatidad() {
        return catidad;
    }

    public void setCatidad(int catidad) {
        this.catidad = catidad;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    @Override
    public String toString() {
        return "Iteam{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", catidad=" + catidad +
                ", costoUnitario=" + costoUnitario +
                '}';
    }
}
