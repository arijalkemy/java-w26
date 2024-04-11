package org.example;

public class Cobradores extends Cliente{
    public void retiroEfectivo() {
        super.getRetiroEfectivo().TransaccionOk();
    }
    public void consultaSaldo() {
        super.getConsultaSaldo().TransaccionOk();
    }
}
