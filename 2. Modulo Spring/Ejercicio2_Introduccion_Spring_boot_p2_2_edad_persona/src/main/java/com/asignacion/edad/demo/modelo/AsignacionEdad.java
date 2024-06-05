package com.asignacion.edad.demo.modelo;

public class AsignacionEdad {
    //Atributos
    private int dia;
    private int mes;
    private int agno;
    private int edad;

    public AsignacionEdad(int dia, int mes, int agno) {
        this.dia = dia;
        this.mes = mes;
        this.agno = agno;
    }

    //------------------------------------------------------------------


    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAgno() {
        return agno;
    }

    public void setAgno(int agno) {
        this.agno = agno;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
