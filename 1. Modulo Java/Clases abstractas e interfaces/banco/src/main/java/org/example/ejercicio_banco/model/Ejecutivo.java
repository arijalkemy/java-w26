package org.example.ejercicio_banco.model;


import java.util.ArrayList;
import java.util.List;

public class Ejecutivo {
    private List<Deposito> depositos;
    private List<Transferencia> transferencias;

    public Ejecutivo() {
        depositos = new ArrayList<>();
        transferencias = new ArrayList<>();
    }

    public String hacerDepositoOk(Deposito deposito) {
        depositos.add(deposito);
        return deposito.transaccionOk();
    }

    public String hacerTransferenciaOk(Transferencia transferencia) {
        transferencias.add(transferencia);
        return transferencia.transaccionOk();
    }

    public String hacerDepositoNoOk(Deposito deposito) {
        return deposito.transaccionOk();
    }

    public String hacerTransferenciaNoOk(Transferencia transferencia) {
        return transferencia.transaccionOk();
    }

    public List<Deposito> getDepositos() {
        return depositos;
    }

    public void setDepositos(List<Deposito> depositos) {
        this.depositos = depositos;
    }

    public List<Transferencia> getTransferencias() {
        return transferencias;
    }

    public void setTransferencias(List<Transferencia> transferencias) {
        this.transferencias = transferencias;
    }
}
