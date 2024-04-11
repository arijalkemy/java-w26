package org.main.ejercicio1.entidades;
import org.main.ejercicio1.interfaces.*;

public class Cobrador implements RetiroDeEfectivo, ConsultaDeSaldo{
    @Override
    public String consultarSaldo() {
        return "El saldo de la cuenta es: "+((int) (Math.random() * (1500 - 1)) + 1)+" \n"+transaccionOK();
    }

    @Override
    public String retirarEfectivo(Double montoRetiro) {
        return "Se retiro: "+montoRetiro+" correctamente \n"+transaccionOK();
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
