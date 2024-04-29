package org.example.logica;

public class PrendaPantalon extends Prenda {
    //Atributos
    private String tipoPantalon;
    private String tallaPantalon;

    //Constructor
    public PrendaPantalon(String marca, String modelo, String tipoPantalon, String tallaPantalon) {
        super(marca, modelo);
        this.tipoPantalon = tipoPantalon;
        this.tallaPantalon = tallaPantalon;
    }

    public String getTipoPantalon() {
        return tipoPantalon;
    }

    public void setTipoPantalon(String tipoPantalon) {
        this.tipoPantalon = tipoPantalon;
    }

    public String getTallaPantalon() {
        return tallaPantalon;
    }

    public void setTallaPantalon(String tallaPantalon) {
        this.tallaPantalon = tallaPantalon;
    }

    @Override
    public String toString() {
        return "PrendaPantalon{" +
                "tipoPantalon='" + tipoPantalon + '\'' +
                ", tallaPantalon='" + tallaPantalon + '\'' +
                '}';
    }
}
