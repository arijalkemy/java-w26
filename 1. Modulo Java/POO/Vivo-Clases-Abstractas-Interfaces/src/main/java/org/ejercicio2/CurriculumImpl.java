package org.ejercicio2;

import java.util.List;

public class CurriculumImpl implements IDocumento {

    private final Persona persona;
    private final List<String> habilidades;

    public CurriculumImpl(Persona persona, List<String> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    public Persona getPersona() {
        return persona;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println(persona);
        System.out.println("Habilidades:");

        for (String habilidad : habilidades)
            System.out.println(habilidad);
    }
}
