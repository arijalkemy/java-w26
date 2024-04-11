package Clientes;

import Transacciones.IConsultaSaldo;
import Transacciones.IRetiroEfectivo;

public class Cobrador implements IConsultaSaldo, IRetiroEfectivo {

    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Retirando efectivo");
    }
}
