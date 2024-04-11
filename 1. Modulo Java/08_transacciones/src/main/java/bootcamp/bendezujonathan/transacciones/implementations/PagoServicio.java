package bootcamp.bendezujonathan.transacciones.implementations;

import bootcamp.bendezujonathan.transacciones.interfaces.ITransaccion;

public class PagoServicio implements ITransaccion {

    @Override
    public void transaccionOk() {
        System.out.println(">> Pago de servicio OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println(">> Pago de servicio NO OK");
    }
}