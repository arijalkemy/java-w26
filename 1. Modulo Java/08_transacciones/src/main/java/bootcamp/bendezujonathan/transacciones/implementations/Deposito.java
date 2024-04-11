package bootcamp.bendezujonathan.transacciones.implementations;

import bootcamp.bendezujonathan.transacciones.interfaces.ITransaccion;

public class Deposito implements ITransaccion {

    @Override
    public void transaccionOk() {
        System.out.println(">> Deposito realizado con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println(">> No se pudo realizar el deposito");
    }
    
}
