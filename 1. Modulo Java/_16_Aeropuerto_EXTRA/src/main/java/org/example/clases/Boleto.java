package org.example.clases;

public class Boleto {
    private Persona persona;
    private TipoDeBoleto tipoDeBoleto;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public TipoDeBoleto getTipoDeBoleto() {
        return tipoDeBoleto;
    }

    public void setTipoDeBoleto(TipoDeBoleto tipoDeBoleto) {
        this.tipoDeBoleto = tipoDeBoleto;
    }

    public Boleto(Persona persona, TipoDeBoleto tipoDeBoleto) {
        this.persona = persona;
        this.tipoDeBoleto = tipoDeBoleto;
    }
}
