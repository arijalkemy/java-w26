package org.example.ejercicio_banco.model;


import java.util.ArrayList;
import java.util.List;

public class Basic {
    private List<ConsultaSaldo> consultaSaldo;
    private List<RetiroEfectivo> retirosEfectivo;
    private List<PagoServicio> pagosServicio;

    public Basic() {
        consultaSaldo = new ArrayList<>();
        retirosEfectivo = new ArrayList<>();
        pagosServicio = new ArrayList<>();
    }

    public String hacerConsultaSaldoOk(ConsultaSaldo consultaSaldo) {
        this.consultaSaldo.add(consultaSaldo);
        return consultaSaldo.transaccionOk();
    }

    public String hacerRetiroEfectivoOk(RetiroEfectivo retiroEfectivo) {
        this.retirosEfectivo.add(retiroEfectivo);
        return retiroEfectivo.transaccionOk();
    }

    public String hacerPagoServicioOk(PagoServicio pagoServicio) {
        this.pagosServicio.add(pagoServicio);
        return pagoServicio.transaccionOk();
    }

    public String hacerConsultaSaldoNoOk(ConsultaSaldo consultaSaldo) {
        return consultaSaldo.transaccionNoOk();
    }

    public String hacerRetiroEfectivoNoOk(RetiroEfectivo retiroEfectivo) {
        return retiroEfectivo.transaccionNoOk();
    }

    public String hacerPagoServicioNoOk(PagoServicio pagoServicio) {
        return pagoServicio.transaccionNoOk();
    }


    public List<ConsultaSaldo> getConsultaSaldo() {
        return consultaSaldo;
    }

    public void setConsultaSaldo(List<ConsultaSaldo> consultaSaldo) {
        this.consultaSaldo = consultaSaldo;
    }

    public List<RetiroEfectivo> getRetirosEfectivo() {
        return retirosEfectivo;
    }

    public void setRetirosEfectivo(List<RetiroEfectivo> retirosEfectivo) {
        this.retirosEfectivo = retirosEfectivo;
    }

    public List<PagoServicio> getPagosServicio() {
        return pagosServicio;
    }

    public void setPagosServicio(List<PagoServicio> pagosServicio) {
        this.pagosServicio = pagosServicio;
    }
}
