package org.example.;

public class Gatos extends Felinos {
    public Gatos(String color) {
        super("Maullido", "Carnívora", "Doméstico", "Felis catus", color);
    }

    @Override
    public String getNombreCientifico() {
        return "Felis catus";
    }

    @Override
    public String getSonido() {
        return "Maullido";
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



