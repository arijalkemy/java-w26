package bootcamp.bendezujonathan.transacciones.implementations;

import bootcamp.bendezujonathan.transacciones.interfaces.ITransaccion;

public class Transferencia implements ITransaccion {

    @Override
    public void transaccionOk() {
        System.out.println(">> Transferencia realizada con exito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println(">> No se pudo realizar la transferencia.");
    }

}
