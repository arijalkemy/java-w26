package Clientes;

import Transacciones.IConsultaSaldo;
import Transacciones.IPagoServicios;
import Transacciones.IRetiroEfectivo;

public class Basic implements IConsultaSaldo, IPagoServicios, IRetiroEfectivo {
    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo");
    }

    @Override
    public void pagarServicio() {
        System.out.println("Pagando servicio");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Retirando efectivo");
    }
}
