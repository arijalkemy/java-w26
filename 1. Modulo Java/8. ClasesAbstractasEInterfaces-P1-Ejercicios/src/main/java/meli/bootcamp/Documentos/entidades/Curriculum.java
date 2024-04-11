package meli.bootcamp.Documentos.entidades;

import meli.bootcamp.Documentos.interfaces.Documento;

import java.util.List;

public class Curriculum implements Documento {
    private String persona;
    private List<String> habilidades;

    public Curriculum(String persona, List<String> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "persona='" + persona + '\'' +
                ", habilidades=" + habilidades +
                '}';
    }
}
