package bootcamp.bendezujonathan.transacciones.implementations;

import bootcamp.bendezujonathan.transacciones.interfaces.ITransaccion;

public class RetiroEfectivo implements ITransaccion {

    @Override
    public void transaccionOk() {
       System.out.println(">> Retiro de efectivo realizado con exito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println(">> No se pudo realizar el retiro de efectivo.");
    }
    
}
