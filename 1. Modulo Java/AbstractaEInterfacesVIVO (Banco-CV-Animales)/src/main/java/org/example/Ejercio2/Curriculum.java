package org.example.Ejercio2;

import java.util.ArrayList;
import java.util.List;

public class Curriculum implements Imprimible{
    //Curriculums: incluye a una persona con todos sus atributos más una lista de sus habilidades
    Persona persona;
    private String experiencia;
    private List<String> listaHabilidades = new ArrayList<>();

    public Curriculum(Persona persona, List<String> listaHabilidades, String experiencia) {
        this.persona = persona;
        this.listaHabilidades = listaHabilidades;
        this.experiencia = experiencia;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public List<String> getListaHabilidades() {
        return listaHabilidades;
    }



// metodo imprecion de cv
    @Override
    public void imprimirDocumento() {
        System.out.println("Curriculum:");
        System.out.println("Nombre:" + persona.getNombreYApellido());
        System.out.println("Nombre:" + persona.getEdad());
        System.out.println("Nombre:" + persona.getDni());
        System.out.println("Nombre:" + this.experiencia);

        for (String habilidad : this.listaHabilidades){
            System.out.println("-" +habilidad);
        }

    }
}
