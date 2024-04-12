package Clientes;

import Clientes.Acciones.ConsultadorSaldo;
import Clientes.Acciones.RetiradorEfectivo;

public class Cobradores implements RetiradorEfectivo, ConsultadorSaldo {

    @Override
    public void retirarEfectivo() {
        System.out.println("Como Cobrador!!!!!");
        RetiradorEfectivo.super.retirarEfectivo();
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Como Cobrador!!!!!");
        ConsultadorSaldo.super.consultarSaldo();
    }
    
}
