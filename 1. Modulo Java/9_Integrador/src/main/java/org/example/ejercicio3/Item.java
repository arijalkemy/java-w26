package org.example.ejercicio3;

public class Item {

    private String codigo;
    private String nombre;
    private String cantidadComprada;
    private String costoUnitario;


    public Item(String codigo, String nombre, String cantidadComprada, String costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadComprada = cantidadComprada;
        this.costoUnitario = costoUnitario;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(String cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    public String getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(String costoUnitario) {
        this.costoUnitario = costoUnitario;
    }


    @Override
    public String toString() {
        return "Item{" +
            "codigo='" + codigo + '\'' +
            ", nombre='" + nombre + '\'' +
            ", cantidadComprada='" + cantidadComprada + '\'' +
            ", costoUnitario='" + costoUnitario + '\'' +
            '}';
    }
}
