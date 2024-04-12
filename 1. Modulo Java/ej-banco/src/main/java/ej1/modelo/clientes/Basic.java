package ej1.modelo.clientes;

import ej1.modelo.transacciones.ConsultaDeSaldo;
import ej1.modelo.transacciones.PagoDeServicios;
import ej1.modelo.transacciones.RetiroDeEfectivo;

import java.util.List;

public class Basic extends TipoDeCliente {

    public Basic(){
        super(List.of(new ConsultaDeSaldo(), new PagoDeServicios(), new RetiroDeEfectivo()));
    }

}
