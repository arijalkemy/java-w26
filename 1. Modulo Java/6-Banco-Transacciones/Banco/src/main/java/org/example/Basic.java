package org.example;

public class Basic extends Cliente{
    public void consultaSaldo() {
        super.getConsultaSaldo().TransaccionOk();
    }
    public void pagoServicios() {
        super.getPagoServicios().TransaccionOk();
    }
    public void retiroEfectivo() {
        super.getRetiroEfectivo().TransaccionOk();
    }
}
