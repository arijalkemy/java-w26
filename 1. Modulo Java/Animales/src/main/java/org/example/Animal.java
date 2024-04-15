package org.example;
// Clase abstracta base para todos los animales
public abstract class Animal {
    protected String sonidos;
    protected String alimentos;
    protected String habitat;
    protected String nombreCientifico;

    public abstract String getNombreCientifico();
    public abstract String getSonido();
    public abstract String getAlimentos();
    public abstract String getHabitat();

    public Animal(String sonidos, String alimentos, String habitat, String nombreCientifico) {
        this.sonidos = sonidos;
        this.alimentos = alimentos;
        this.habitat = habitat;
        this.nombreCientifico = nombreCientifico;
    }
}
