package org.main.ejercicio1.entidades;

import org.main.ejercicio1.interfaces.*;

public class Ejecutivo implements Deposito, Transferencia{
    @Override
    public String depositar(double monto) {
        return "Se deposito: "+monto+" correctamente \n"+transaccionOK();
    }

    @Override
    public String transferenciaOK(String destino, Double monto) {
        return "Se transfirio: "+monto+" a la cuenta: "+destino+" correctamente \n"+transaccionOK();
    }

    @Override
    public String transferenciaNoOK(String destino, Double monto) {
        return null;
    }
    @Override
    public String transaccionOK() {
        return "Transacción exitosa";
    }

    @Override
    public String transaccionNoOk() {
        return "Transacción fallida";
    }

}
