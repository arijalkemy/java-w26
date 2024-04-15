package org.example.ciudad;

public class Ciudad {
    private String name;
    private String country;
    private int noVisitantes;
    
    public Ciudad(String name, String country) {
        this.name = name;
        this.country = country;
        this.noVisitantes = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getNoVisitantes() {
        return noVisitantes;
    }

    public void setNoVisitantes(int noVisitantes) {
        this.noVisitantes = noVisitantes;
    }
}
