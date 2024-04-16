package org.example;

public class Circuits {
    private int idCircuit;
    private String name;
    private int length;
    private String location;
    private double childPrice;
    private double adultPrice;
    private boolean isAdultOnly;

    public Circuits(int idCircuit, String name, int length, String location, double childPrice, double adultPrice) {
        this.idCircuit = idCircuit;
        this.name = name;
        this.length = length;
        this.location = location;
        this.adultPrice = adultPrice;
        this.childPrice = childPrice;
        isAdultOnly = false;
    }

        public Circuits(int idCircuit, String name, int length, String location, double adultPrice, boolean isAdultOnly) {
        this.idCircuit = idCircuit;
        this.name = name;
        this.length = length;
        this.location = location;
        this.adultPrice = adultPrice;
        this.isAdultOnly = isAdultOnly;
    }

    public int getIdCircuit() {
        return idCircuit;
    }

    public void setIdCircuit(int idCircuit) {
        this.idCircuit = idCircuit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(double adultPrice) {
        this.adultPrice = adultPrice;
    }

    public double getChildPrice() {
        return childPrice;
    }

    public void setChildPrice(double childPrice) {
        this.childPrice = childPrice;
    }

    public boolean isAdultOnly() {
        return isAdultOnly;
    }

    public void setAdultOnly(boolean isAdultOnly) {
        this.isAdultOnly = isAdultOnly;
    }

    @Override
    public String toString() {
        return "Circuits [idCircuit=" + idCircuit + ", name=" + name + ", length=" + length + ", location=" + location
                + ", adultPrice=" + adultPrice + ", childPrice=" + childPrice + ", isAdultOnly=" + isAdultOnly + "]";
    }
}
