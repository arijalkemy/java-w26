package org.ejercicio1;

public class Ejecutivo extends Cliente {
    private final DepositoImpl deposito;

    public Ejecutivo(String nombre) {
        super(nombre);
        deposito = new DepositoImpl();
    }

    @Override
    public void realizarDeposito(DepositoImpl deposito) {
        System.out.println("deposito realizado");
    }

    @Override
    public void consultarSaldo(ConsultaSaldoImpl consulta) {
        System.out.println("asldjsaldjsd");
    }
}
