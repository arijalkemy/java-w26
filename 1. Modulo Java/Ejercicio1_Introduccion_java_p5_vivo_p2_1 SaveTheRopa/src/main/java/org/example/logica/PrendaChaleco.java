package org.example.logica;

public class PrendaChaleco extends Prenda{
    //Atributos
    private String tipoChaleco;
    private String tallaChaleco;

    //Atributos
    public PrendaChaleco(String marca, String modelo, String tipoChaleco, String tallaChaleco) {
        super(marca, modelo);
        this.tipoChaleco = tipoChaleco;
        this.tallaChaleco = tallaChaleco;
    }

    public String getTipoChaleco() {
        return tipoChaleco;
    }

    public void setTipoChaleco(String tipoChaleco) {
        this.tipoChaleco = tipoChaleco;
    }

    public String getTallaChaleco() {
        return tallaChaleco;
    }

    public void setTallaChaleco(String tallaChaleco) {
        this.tallaChaleco = tallaChaleco;
    }

    @Override
    public String toString() {
        return "PrendaChaleco{" +
                "tipoChaleco='" + tipoChaleco + '\'' +
                ", tallaChaleco='" + tallaChaleco + '\'' +
                '}';
    }
}
