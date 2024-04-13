package org.example.ejer2;
import java.util.List;

public class Curriculum implements IImpresion{
    private String persona;
    private List<String> habilidades;

    public Curriculum(String persona, List<String> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public void impresionDeInformacion() {
        System.out.println("Curriculum: Persona %s" + this.persona + "- Habilidades");
        for(String skill: this.habilidades){
            System.out.println(skill);
        }
    }
}
