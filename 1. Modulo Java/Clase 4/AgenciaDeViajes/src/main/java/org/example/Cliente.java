package org.example;

public class Cliente {

    private Long id;
    private String nombre;
    private int descuentoAcumulado ;


    public Cliente(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        descuentoAcumulado = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDescuentoAcumulado() {
        return descuentoAcumulado;
    }

    public void setDescuentoAcumulado(int descuentoAcumulado) {
        this.descuentoAcumulado = descuentoAcumulado;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descuentoAcumulado=" + descuentoAcumulado +
                '}';
    }
}
