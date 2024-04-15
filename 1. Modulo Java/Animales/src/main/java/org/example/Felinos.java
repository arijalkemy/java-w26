package org.example.;
public abstract class Felinos extends Animal {
    public String color;
    public Felinos(String sonidos, String alimentos, String habitat, String nombreCientifico, String color) {
        super(sonidos, alimentos, habitat, nombreCientifico);
        this.color = color;
    }

}
