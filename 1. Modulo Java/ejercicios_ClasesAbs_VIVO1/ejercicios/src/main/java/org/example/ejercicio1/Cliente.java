package org.example.ejercicio1;

public abstract class Cliente {
    protected ITransaccion transaccion;
    public void retirarEfectivo(){
        transaccion=new RetiroEfectivo();
    };
    public void realizarDeposito(){
        transaccion=new Deposito();
    };
    public void realizarTransferencia(){
        transaccion=new Transferencia();
    };
    public void realizarConsultaDeSaldo(){
        transaccion=new ConsultaDeSaldo();
    };
    public void realizarPagoDeServicios(){
        transaccion=new PagoDeServicios();
    };
}
