package org.example;
//clase del objerto curriculum que implementa la interfaz iprimible
public class Curriculum implements Imprimible{
    private String name;    //Atributos de la clase
    private String profesion;
    private String habilidades;
    //Constructor de la clase
    public Curriculum(String name, String profesion, String habilidades) {
        this.name = name;
        this.profesion = profesion;
        this.habilidades = habilidades;
    }
    //metodo imprimir que sobreescribe el metodo de la interfaz
    @Override
    public void imprimir() {
        System.out.println("Imprimiendo CV de "+name);
    }
}
