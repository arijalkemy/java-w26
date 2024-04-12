package Clientes;

import Clientes.Acciones.ConsultadorSaldo;
import Clientes.Acciones.PagadorServicios;
import Clientes.Acciones.RetiradorEfectivo;

public class Basic implements ConsultadorSaldo, PagadorServicios, RetiradorEfectivo {

    @Override
    public void consultarSaldo() {
        System.out.println("Como Basic!!!!");
        ConsultadorSaldo.super.consultarSaldo();
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Como Basic!!!");
        RetiradorEfectivo.super.retirarEfectivo();
    }

}
