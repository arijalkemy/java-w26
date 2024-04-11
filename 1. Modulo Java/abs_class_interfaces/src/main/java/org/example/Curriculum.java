package org.example;

public class Curriculum implements IPrintDoc{
    final private String name;
    final private String lastname;
    final private String skills;

    public Curriculum() {
        this.name = "Juan";
        this.lastname = "Castro";
        this.skills = "Hablar";
    }

    @Override
    public String printDoc() {
        return "Nombre: "+this.name+" | apellido: "+this.lastname+" | habilidades: "+this.skills;
    }
}
