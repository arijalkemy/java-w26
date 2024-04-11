package org.ejercicio1;

public class Basic extends Cliente {

    public Basic(String nombre) {
        super(nombre);
    }

    @Override
    public void realizarDeposito(DepositoImpl deposito) {
        deposito.transaccionNoOk();
    }

    @Override
    public void consultarSaldo(ConsultaSaldoImpl consulta) {

    }
}
