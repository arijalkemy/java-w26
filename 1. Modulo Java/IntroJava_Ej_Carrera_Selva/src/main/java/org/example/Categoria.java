package org.example;

public class Categoria {

    private static int CONTADOR = 0;
    private int id;
    private String nombre;
    private String descripcion;
    private int montoTotal = 0;
    public Categoria( String nombre, String descripcion){
        this.id = CONTADOR++;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId(){
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMontoTotal() {
        return montoTotal;
    }

    public void sumarMonto(int monto){
        this.montoTotal += monto;
    }

    public void restarMonto(int monto){
        this.montoTotal -= monto;
    }
}
