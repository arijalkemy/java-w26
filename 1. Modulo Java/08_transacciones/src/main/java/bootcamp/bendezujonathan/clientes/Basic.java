package bootcamp.bendezujonathan.clientes;

import bootcamp.bendezujonathan.transacciones.implementations.PagoServicio;
import bootcamp.bendezujonathan.transacciones.interfaces.ITransaccion;

public class Basic  extends BasicOperationClient {

    private ITransaccion pagoServicios;
    
    public Basic() {
        this.pagoServicios = new PagoServicio();
    }
 
    public void pagarServicios() {
        this.pagoServicios.transaccionOk();
    }


}
