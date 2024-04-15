package org.example;

public class Cobrador implements IRetiroEfectivo, IConsultaSaldo{
    private final int RETIRO = 1;
    private final int CONSULTA = 2;

    private int transaccion;

    public Cobrador(int transaccion) {
        this.transaccion = transaccion;
    }

    @Override
    public void transaccionOk() {
        if(transaccion == CONSULTA)
            IRetiroEfectivo.super.transaccionOk();
        else if(transaccion == RETIRO)
            IConsultaSaldo.super.transaccionOk();
        else
            System.out.println("Transacción inválida");
    }

    @Override
    public void transaccionNoOk() {
        if(transaccion == CONSULTA)
            IRetiroEfectivo.super.transaccionNoOk();
        else if(transaccion == RETIRO)
            IConsultaSaldo.super.transaccionNoOk();
        else
            System.out.println("Transacción inválida");
    }
}
