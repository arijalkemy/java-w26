package org.example;

public abstract class Cliente {
    private Deposito deposito = new Deposito();
    private Transferencias transferencias = new Transferencias();
    private RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
    private ConsultaSaldo consultaSaldo = new ConsultaSaldo();
    private PagoServicios pagoServicios = new PagoServicios();
    public Deposito getDeposito() {
        return deposito;
    }

    public Transferencias getTransferencias() {
        return transferencias;
    }

    public RetiroEfectivo getRetiroEfectivo() {
        return retiroEfectivo;
    }

    public ConsultaSaldo getConsultaSaldo() {
        return consultaSaldo;
    }

    public PagoServicios getPagoServicios() {
        return pagoServicios;
    }
}
