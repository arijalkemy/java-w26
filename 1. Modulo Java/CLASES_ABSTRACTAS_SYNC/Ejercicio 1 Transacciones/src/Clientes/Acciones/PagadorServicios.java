package Clientes.Acciones;

import Transacciones.Transaccion;
import Transacciones.IEjecutadorTransacciones;
import Transacciones.TrPagarServicios;
public interface PagadorServicios {
    default public void pagarServicios()
    {
        Transaccion transaccion = new TrPagarServicios();
        System.out.println("Pagando servicios...");
        IEjecutadorTransacciones.ejecutar(transaccion);
    }
}
