package org.example.Ejercicio1;

public class Ejecutivo extends EstadoTransaccion implements TransaccionEjecutivo{
    String nombre;

    public Ejecutivo(String nombre) {
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
    public void depositar(double monto) {
        System.out.print("Deposito realizado con exito");
    }

    @Override
    public void transferir(double monto) {
        System.out.print("Transferencia realizada con exito");
    }
}
