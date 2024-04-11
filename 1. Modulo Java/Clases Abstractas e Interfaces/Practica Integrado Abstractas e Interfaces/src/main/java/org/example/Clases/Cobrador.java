package org.example.Clases;

import org.example.Interfaces.ConsultaSaldo;
import org.example.Interfaces.RetiroDeEfectivo;

public class Cobrador implements ConsultaSaldo, RetiroDeEfectivo {

    public void consultarSaldo() {
        System.out.println("Su saldo es de 1000$, desde cobrador");

    }

    public void retirarEfectivo() {
        System.out.println("Se retiro 1000$, desde cobrador");

    }

    public void transaccionOk() {
        System.out.println("Transsacion Ok, desde cobrador");

    }

    public void transaccionNoOk() {
        System.out.println("Transaccion NoOk, desde cobrador");

    }
}
