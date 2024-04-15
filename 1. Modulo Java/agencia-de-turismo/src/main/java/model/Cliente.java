package model;

import Interfaces.ILocalizador;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String apellido;
    private String dni;

    List<ILocalizador> localizadorList = new ArrayList<>();
    public Cliente(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public void guardarNuevoLocalizador(ILocalizador localizador){
        this.localizadorList.add(localizador);
    }

    public List<ILocalizador> getLocalizadorList() {
        return localizadorList;
    }

    public void setLocalizadorList(List<ILocalizador> localizadorList) {
        this.localizadorList = localizadorList;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
