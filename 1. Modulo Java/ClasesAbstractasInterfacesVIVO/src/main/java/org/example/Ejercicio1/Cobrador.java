package org.example.Ejercicio1;

public class Cobrador extends EstadoTransaccion implements TransaccionCobradores{
    String nombre;

    public Cobrador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void esValido() {
        System.out.print("Transaccion valida");
    }

    @Override
    public void noEsValido() {
        System.out.print("Transaccion no valida");
    }

    @Override
    public void retirar() {
        System.out.print("Retiro realizado con exito");
    }

    @Override
    public void consultarSaldo() {
        System.out.print("Saldo consultado");
    }
}
