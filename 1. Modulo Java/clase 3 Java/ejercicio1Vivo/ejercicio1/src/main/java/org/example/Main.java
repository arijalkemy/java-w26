package org.example;

public class Main {
    public static void main(String[] args) {
        Basic personBasic = new Basic(300000);
        personBasic.consultaDeSaldo();
        personBasic.transactionOk();

        personBasic.retiroEfectivo(15000);

        Cobrador cobrador = new Cobrador(35000);
        cobrador.consultaDeSaldo();
    }
}