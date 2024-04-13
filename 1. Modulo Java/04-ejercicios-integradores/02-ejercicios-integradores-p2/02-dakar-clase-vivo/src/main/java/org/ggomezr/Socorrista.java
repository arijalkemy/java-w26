package org.ggomezr;

public class Socorrista {
    private String nombre;
    private String apellido;

    public Socorrista(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public void socorrer(Vehiculo vehiculo){
        System.out.println("Socorrista " + this.nombre + " " + this.apellido + " esta socorriendo al vehiculo " + vehiculo.getTipoVehiculo() + " con patente: " + vehiculo.getPatente());
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
}
