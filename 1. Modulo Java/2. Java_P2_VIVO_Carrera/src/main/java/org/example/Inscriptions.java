package org.example;

public class Inscriptions {
    private int idInscription;
    private int category;
    private int idCompetitor;
    private double price;

    public Inscriptions(int idInscription, int category, int idCompetitor, double price) {
        this.idInscription = idInscription;
        this.category = category;
        this.idCompetitor = idCompetitor;
        this.price = price;
    }

    public int getIdInscription() {
        return idInscription;
    }

    public void setIdInscription(int idInscription) {
        this.idInscription = idInscription;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getIdCompetitor() {
        return idCompetitor;
    }

    public void setIdCompetitor(int idCompetitor) {
        this.idCompetitor = idCompetitor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Inscriptions [idInscription=" + idInscription + ", category=" + category + ", idCompetitor="
                + idCompetitor + ", price=" + price + "]";
    }    
}
