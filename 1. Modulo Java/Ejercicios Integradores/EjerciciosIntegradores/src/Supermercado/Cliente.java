package Supermercado;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
   private String dni;
    private String nombre;
    private String apellido;

    private List<Factura> historial;

    public Cliente(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;

        historial = new ArrayList<>();
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void addFactura(Factura nuevaFactura){
        historial.add(nuevaFactura);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", historial=" + historial.toString() +
                '}';
    }
}
