package org.example.ejercicio_banco.model;



import java.util.ArrayList;
import java.util.List;

public class Cobrador {
    private List<RetiroEfectivo> retirosEfectivo;
    private List<ConsultaSaldo> consultaSaldo;

    public Cobrador() {
        retirosEfectivo = new ArrayList<>();
        consultaSaldo = new ArrayList<>();
    }

    public String hacerConsultaSaldoOk(ConsultaSaldo consultaSaldo) {
        this.consultaSaldo.add(consultaSaldo);
        return consultaSaldo.transaccionOk();
    }

    public String hacerRetiroEfectivoOk(RetiroEfectivo retiroEfectivo) {
        this.retirosEfectivo.add(retiroEfectivo);
        return retiroEfectivo.transaccionOk();
    }

    public String hacerConsultaSaldoNoOk(ConsultaSaldo consultaSaldo) {
        return consultaSaldo.transaccionNoOk();
    }

    public String hacerRetiroEfectivoNoOk(RetiroEfectivo retiroEfectivo) {
        return retiroEfectivo.transaccionNoOk();
    }


    public List<RetiroEfectivo> getRetirosEfectivo() {
        return retirosEfectivo;
    }

    public void setRetirosEfectivo(List<RetiroEfectivo> retirosEfectivo) {
        this.retirosEfectivo = retirosEfectivo;
    }

    public List<ConsultaSaldo> getConsultaSaldo() {
        return consultaSaldo;
    }

    public void setConsultaSaldo(List<ConsultaSaldo> consultaSaldo) {
        this.consultaSaldo = consultaSaldo;
    }
}
