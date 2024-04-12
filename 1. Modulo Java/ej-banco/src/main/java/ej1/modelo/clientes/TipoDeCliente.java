package ej1.modelo.clientes;

import ej1.interfaces.ITransaccion;

import java.util.List;

public abstract class TipoDeCliente {

    private List<ITransaccion> transaccionesPermitidas;

    public boolean permiteTransaccion(ITransaccion transaccion){
        // se deberia comparar por id, pero por simplicidad lo hago con el nombre de la clase
        // y no por igualdad ya que la referencia puede ser distinta a pesar de ser de la misma clase
        return  transaccionesPermitidas.stream().anyMatch(t -> {
            return t.getClass().toString().equals(transaccion.getClass().toString());
        });
    }

    public TipoDeCliente(List<ITransaccion> transaccionesPermitidas) {
        this.transaccionesPermitidas = transaccionesPermitidas;
    }
}
