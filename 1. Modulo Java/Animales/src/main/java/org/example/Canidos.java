package org.example.;
public abstract class Canidos extends Animal {
    public String color;
    public Canidos(String sonidos, String alimentos, String habitat, String nombreCientifico, String color) {
        super(sonidos, alimentos, habitat, nombreCientifico);
        this.color = color;
    }
}
