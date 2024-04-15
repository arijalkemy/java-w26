package org.example.entidad;

public class Item {
    private Long codigo;
   private String nombre;
   private int cantidadComprada;
   private Double costoUnitario;

    public Item(Long codigo, int cantidadComprada, String nombre, Double costoUnitario) {
        this.codigo = codigo;
        this.cantidadComprada = cantidadComprada;
        this.nombre = nombre;
        this.costoUnitario = costoUnitario;
    }

    public Double calcularCantidadTotal(){
        return costoUnitario * cantidadComprada;
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

    public int getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(int cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    public Double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(Double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", cantidadComprada=" + cantidadComprada +
                ", costoUnitario=" + costoUnitario +
                '}';
    }
}
