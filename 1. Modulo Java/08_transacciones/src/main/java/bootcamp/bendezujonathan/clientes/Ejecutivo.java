package bootcamp.bendezujonathan.clientes;

import bootcamp.bendezujonathan.transacciones.implementations.Deposito;
import bootcamp.bendezujonathan.transacciones.implementations.Transferencia;
import bootcamp.bendezujonathan.transacciones.interfaces.ITransaccion;

public class Ejecutivo {
    
    private ITransaccion deposito;
    private ITransaccion transferencia;

    public Ejecutivo() {
        this.deposito = new Deposito();
        this.transferencia = new Transferencia();
    }


    public void depositar(){
        this.deposito.transaccionOk();
    }

    public void transferir() {
        this.transferencia.transaccionNoOk();
    }
}
