package ej1.modelo.banco;

import ej1.interfaces.ITransaccion;
import ej1.modelo.clientes.Cliente;

public class Banco {

    public void aplicarTransaccion(ITransaccion transaccion, Cliente cliente){

        boolean seCompletoExitosamente = cliente.getTipoDeCliente().permiteTransaccion(transaccion);

        if(seCompletoExitosamente){
            transaccion.transaccionOk();
        } else {
            transaccion.transaccionNoOk();
        }
    }
}
