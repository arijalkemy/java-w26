package Clientes.Acciones;

import Transacciones.IEjecutadorTransacciones;
import Transacciones.TrTransferencia;
import Transacciones.Transaccion;

public interface Transferidor {

    default public void transferir()
    {
        
        final Transaccion transaccion = new TrTransferencia();
        System.out.println("Transfiriendo...");
        IEjecutadorTransacciones.ejecutar(transaccion);
    }
}
