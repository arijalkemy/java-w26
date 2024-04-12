package ej1.modelo.clientes;

public class Cliente {

    private TipoDeCliente tipoDeCliente;

    public Cliente(TipoDeCliente tipoDeCliente) {
        this.tipoDeCliente = tipoDeCliente;
    }

    public TipoDeCliente getTipoDeCliente() {
        return tipoDeCliente;
    }
}
