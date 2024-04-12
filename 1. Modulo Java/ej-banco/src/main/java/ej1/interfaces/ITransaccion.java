package ej1.interfaces;

import ej1.modelo.clientes.Cliente;

public interface ITransaccion {

    // cada transaccion deberia implementar su ejecutar, por eso se le injecta el cliente
    default boolean ejecutar(Cliente cliente){
        return Math.random() <= 0.5;
    }


    public void transaccionOk();
    public void transaccionNoOk();
}
