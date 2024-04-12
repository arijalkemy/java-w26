package ej1.modelo.clientes;

import ej1.modelo.transacciones.ConsultaDeSaldo;
import ej1.modelo.transacciones.RetiroDeEfectivo;

import java.util.List;

public class Cobradores extends TipoDeCliente {

    public Cobradores() {
        super(List.of(new RetiroDeEfectivo(), new ConsultaDeSaldo()));
    }
}
