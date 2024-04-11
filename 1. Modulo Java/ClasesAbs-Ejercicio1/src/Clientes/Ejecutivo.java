package Clientes;

import Transacciones.IDeposito;
import Transacciones.ITransferencia;

public class Ejecutivo implements IDeposito, ITransferencia {
    @Override
    public void depositar() {
        System.out.println("Realizando deposito");
    }

    @Override
    public void transferir() {
        System.out.println("Realizando transferencia");
    }
}
