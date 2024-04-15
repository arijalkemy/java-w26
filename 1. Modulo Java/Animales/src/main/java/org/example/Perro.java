package org.example.;

public class Perro extends Canidos {
    public Perro(String color) {
        super("Ladrido", "Carnívora", "Doméstico", "Canis lupus familiaris", color);
    }

    @Override
    public String getNombreCientifico() {
        return "Canis lupus familiaris";
    }

    @Override
    public String getSonido() {
        return "Ladrido";
    }

    @Override
    public String getAlimentos() {
        return "Carnívora";
    }

    @Override
    public String getHabitat() {
        return "Doméstico";
    }
}



