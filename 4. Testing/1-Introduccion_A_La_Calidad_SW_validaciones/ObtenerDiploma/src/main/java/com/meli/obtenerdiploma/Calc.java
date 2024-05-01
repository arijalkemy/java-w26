package com.meli.obtenerdiploma;

public class Calc implements Operacion{
    private Operacion operacion;

    public void setOperacion(Operacion operacion){
        this.operacion = operacion;
    }
    public int resolver(int numUno, int numDos){
        return this.operacion.resolver(numUno,numDos);
    }

    public int sumar(int numUno, int numDos){
        return numDos + numUno;
    }
    public int restar(int numUno, int numDos){
        return numUno - numDos;
    }
}
