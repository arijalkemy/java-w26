package Clientes.Acciones;


import Transacciones.IEjecutadorTransacciones;
import Transacciones.TrDeposito;
import Transacciones.Transaccion;

public interface Depositador {

    default public void depositar()
    {
        final Transaccion transaccion = new TrDeposito();
        System.out.println("Depositando...");
        IEjecutadorTransacciones.ejecutar(transaccion);
    }
    
}
