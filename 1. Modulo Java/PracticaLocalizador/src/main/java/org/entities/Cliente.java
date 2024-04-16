package org.entities;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int id;
    private String dni;
    private String nombre;
    private String apellido;
    private List<Localizador> localizadores;
    private double descuento = 0;
    private double descuentoFutura = 0;

    public Cliente(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        localizadores = new ArrayList<>();
    }

    @Override
    public String toString() {
        String info = "Cliente= " +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'';
        for (Localizador localizador : localizadores) {
            info += ", localizador=" + localizador.toString();
        }
        return info;
    }

    public void agregarDescuento(Localizador localizador){
        if(localizadores.size() >= 2){
            descuentoFutura = 0.05;
        }

        if(localizador.getBoletos() >= 2 || localizador.getHotel() >= 2){
            descuento = 0.05;
        }

        if(localizador.tienePaqueteCompleto()){
            descuento = 0.1;
        }

        localizador.setTotal(localizador.getTotal() - (localizador.getTotal() * (descuento)));
        localizador.setTotal(localizador.getTotal() - (localizador.getTotal() * (descuentoFutura)));
    }

    public void agregarLocalizador(Localizador localizador) {
        localizadores.add(localizador);
        agregarDescuento(localizador);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }
}
