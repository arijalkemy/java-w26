package org.example.Ejercicio1;

public  class Basic extends EstadoTransaccion implements TransaccionBasic{
    String nombre;

    public Basic(String nombre) {
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
    public void consultarSaldo() {
        System.out.print("Saldo consultado");
    }

    @Override
    public void retirar() {
        System.out.print("Retiro realizado con exito");
    }

    @Override
    public void pagarServicio() {
        System.out.print("Pago realizado con exito");
    }
}
