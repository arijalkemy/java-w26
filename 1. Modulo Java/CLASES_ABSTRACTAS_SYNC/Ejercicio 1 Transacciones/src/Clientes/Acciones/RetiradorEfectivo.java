package Clientes.Acciones;

import Transacciones.IEjecutadorTransacciones;
import Transacciones.TrRetiroEfectivo;
import Transacciones.Transaccion;

public interface RetiradorEfectivo {
    default public void retirarEfectivo()
    {
        Transaccion transaccion = new TrRetiroEfectivo();
        System.out.println("Retirando dinero...");
        IEjecutadorTransacciones.ejecutar(transaccion);
    }
}
