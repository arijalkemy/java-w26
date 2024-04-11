package bootcamp.bendezujonathan.transacciones.implementations;

import bootcamp.bendezujonathan.transacciones.interfaces.ITransaccion;

public class ConsultaSaldo implements ITransaccion {

    @Override
    public void transaccionOk() {
        System.out.println(">> Transaccion realizada con exito, su saldo es: $1000");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println(">> No se pudo realizar la transaccion 'Consultar Saldo'");
    }
    

}
