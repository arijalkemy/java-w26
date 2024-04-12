package Clientes.Acciones;

import Transacciones.Transaccion;
import Transacciones.IEjecutadorTransacciones;
import Transacciones.TrConsultarSaldo;

public interface ConsultadorSaldo {

    default public void consultarSaldo()
    {
        Transaccion transaccion = new TrConsultarSaldo();
        System.out.println("Consultando saldo...");
        IEjecutadorTransacciones.ejecutar(transaccion);
    } 
}
