package org.example.model;

import java.util.List;

public class Curriculum implements Imprimible{
    private Persona persona;
    private List<String> habilidades;

    public Curriculum(){}

    public Curriculum(Persona persona, List<String> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum " + "\n"+
                persona.toString() +
                " Habilidades=" + habilidades + "\n";
    }


    @Override
    public void imprimirDocumento() {
        System.out.println(this);
    }

    @Override
    public void imprimirTipoDocumento() {
        System.out.println("Curriculum");
    }
}

