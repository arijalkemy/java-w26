package bootcamp.bendezujonathan.clientes;

import bootcamp.bendezujonathan.transacciones.implementations.ConsultaSaldo;
import bootcamp.bendezujonathan.transacciones.implementations.RetiroEfectivo;
import bootcamp.bendezujonathan.transacciones.interfaces.ITransaccion;

public abstract class BasicOperationClient {
    
    private final ITransaccion consultarSaldo = new ConsultaSaldo();
    private final ITransaccion retiroEfectivo = new RetiroEfectivo();

    public void consultarSaldo() {
        this.consultarSaldo.transaccionOk();
    };

    public void retirarEfectivo(){ 
        this.retiroEfectivo.transaccionOk();
    }

}
