package org.example;

public class Cobrador {

    private Retiro retiroEfectivo;
    private Consulta consultaSaldo;

    public Cobrador() {
        this.retiroEfectivo = new Retiro();
        this.consultaSaldo = new Consulta();
    }

    public Retiro getRetiroEfectivo() {
        return this.retiroEfectivo;
    }

    public void setRetiroEfectivo(Retiro retiroEfectivo) {
        this.retiroEfectivo = retiroEfectivo;
    }

    public Consulta getConsultaSaldo() {
        return this.consultaSaldo;
    }

    public void setConsultaSaldo(Consulta consultaSaldo) {
        this.consultaSaldo = consultaSaldo;
    }
}
