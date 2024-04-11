package org.example.clientes;

import org.example.interfaces.IRetiroEfectivo;
import org.example.interfaces.ISaldo;

public class Cobrador implements ISaldo, IRetiroEfectivo {

    public Cobrador() {
    }

    public void consultar_saldo() {
        System.out.println("Hizo una consulta de saldo");
    }


    public void retirar_efectivo() {
        System.out.println("Hizo un retiro de efectivo");
    }
}
