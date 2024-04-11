package org.ejercicio1;

public abstract class Cliente {
    private String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public abstract void realizarDeposito(DepositoImpl deposito);
    public abstract void consultarSaldo(ConsultaSaldoImpl consulta);
}
