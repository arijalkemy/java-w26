package org.meli.clases;

public class Vehiculo {
    private Double velocidad;
    private Double aceleracion;
    private Double anguloDeGiro;
    private String patente;
    private Double peso;
    private Integer ruedas;
    private String categoria;

    public Vehiculo(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente, Double peso, Integer ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
        if (this.peso==1000.0 && this.ruedas==4){
            this.categoria = "Auto";
        }else if(this.peso==300.0 && this.ruedas==2){
            this.categoria = "Moto";
        }else{
            this.categoria = "NA";
        }
    }

    public Double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Double velocidad) {
        this.velocidad = velocidad;
    }

    public Double getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(Double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public Double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(Double anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Integer getRuedas() {
        return ruedas;
    }

    public void setRuedas(Integer ruedas) {
        this.ruedas = ruedas;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double definirGanador(){
        return this.velocidad * (this.aceleracion / 2) / (this.anguloDeGiro * (this.peso - this.ruedas * 100));
    }
}
