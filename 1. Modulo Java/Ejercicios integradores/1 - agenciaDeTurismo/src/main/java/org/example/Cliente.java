package org.example;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int id;
    private String nombre;
    private List<Localizador> localizadores;

    // Constructor para inicializar el cliente con un identificador y nombre, y una lista vacía de localizadores
    public Cliente(int id, String nombre, List<Localizador> localizadores) {
        this.id = id;
        this.nombre = nombre;
        this.localizadores = new ArrayList<>();
    }

    // Getters y Setters
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

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    // Método para agregar localizadores al cliente
    public void agregarLocalizador(Localizador localizador) {
        if (localizador != null) {
            this.localizadores.add(localizador);
        }
    }

    // Método toString para imprimir detalles del cliente de manera conveniente
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", localizadores=" + localizadores.size() + // Mostrar cantidad de localizadores
                '}';
    }
}
