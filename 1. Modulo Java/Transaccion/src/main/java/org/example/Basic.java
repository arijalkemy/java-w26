package org.example;

public class Basic {

    private Pago pagoServicios;
    private Consulta consultaSaldo;
    private Retiro retiroEfectivo;

    public Basic() {
        this.pagoServicios = new Pago();
        this.consultaSaldo = new Consulta();
        this.retiroEfectivo = new Retiro();
    }

    public Pago getPagoServicios() {
        return this.pagoServicios;
    }

    public void setPagoServicios(Pago pagoServicios) {
        this.pagoServicios = pagoServicios;
    }

    public Consulta getConsultaSaldo() {
        return this.consultaSaldo;
    }

    public void setConsultaSaldo(Consulta consultaSaldo) {
        this.consultaSaldo = consultaSaldo;
    }

    public Retiro getRetiroEfectivo() {
        return this.retiroEfectivo;
    }

    public void setRetiroEfectivo(Retiro retiroEfectivo) {
        this.retiroEfectivo = retiroEfectivo;
    }

}
