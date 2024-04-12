package org.ejercicio2.clases;

import org.ejercicio2.interfaces.IDocumento;

import java.util.List;

public class Curriculum implements IDocumento {

    private Persona persona;
    private List<String> habilidades;

    public Curriculum(Persona persona, List<String> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    public Persona getPersona() {
        return persona;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Postulante: " + persona);
        System.out.println("Habilidades:");

        for (String habilidad : habilidades)
            System.out.println(habilidad);
    }
}
